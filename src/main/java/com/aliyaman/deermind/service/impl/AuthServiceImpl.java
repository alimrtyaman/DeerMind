package com.aliyaman.deermind.service.impl;

import com.aliyaman.deermind.Jwt.AuthRequest;
import com.aliyaman.deermind.Jwt.AuthResponse;
import com.aliyaman.deermind.Jwt.JwtService;
import com.aliyaman.deermind.dto.DtoUser;
import com.aliyaman.deermind.entity.CustomUserDetails;
import com.aliyaman.deermind.entity.User;
import com.aliyaman.deermind.repository.UserRepository;
import com.aliyaman.deermind.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {


    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;


    @Override
    public DtoUser register(AuthRequest request){
        User user = new User();
        DtoUser dtoUser = new DtoUser();
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        BeanUtils.copyProperties(savedUser , dtoUser);
        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request){
        try{
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
            Optional<User> optional = userRepository.findByUsername(request.getUsername());
            if (optional.isEmpty()){
                return null;
            }
            User user = optional.get();
            CustomUserDetails customU = new CustomUserDetails(user);
            String accessToken = jwtService.generateToken(customU);

            return new AuthResponse(accessToken);
        }catch (Exception e){
            System.out.println("invalid user name and password " + e.getMessage());
        }
        return null;
    }


}
