package com.aliyaman.deermind.controller.impl;

import com.aliyaman.deermind.Jwt.AuthRequest;
import com.aliyaman.deermind.Jwt.AuthResponse;
import com.aliyaman.deermind.controller.IAuthController;
import com.aliyaman.deermind.dto.DtoUser;
import com.aliyaman.deermind.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements IAuthController {

    @Autowired
    private IAuthService iAuthService;

    @PostMapping("/register")
    @Override
    public DtoUser register(@RequestBody AuthRequest request) {
        return iAuthService.register(request);
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@RequestBody AuthRequest request) {
        return iAuthService.authenticate(request);
    }
}
