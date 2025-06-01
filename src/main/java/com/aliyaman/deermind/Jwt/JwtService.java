package com.aliyaman.deermind.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    private static final String SECRET_KEY = "iWKjCZOoys608C8hJ3zGB4vjxlYTSypMe8zDlQQ1YE12345";


    public String generateToken(UserDetails userDetails){
        Map<String , Object> claimsMap = new HashMap<>();
        claimsMap.put("role" , "Admin");
        return
        Jwts.builder().setSubject(userDetails.getUsername())
                .addClaims(claimsMap)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(getKey() , SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token){
        Claims claims =
                Jwts.parserBuilder().setSigningKey(getKey()).build()
                        .parseClaimsJws(token).getBody();
        return claims;
    }

    public <T> T exportToken(String token , Function<Claims , T> claimsFunction){
        Claims claims = getClaims(token);
        return claimsFunction.apply(claims);
    }

    public String getUserNameByToken(String token){
        return exportToken(token ,Claims::getSubject);
    }

    public boolean isTokenExpired(String token){
        Date expiredDate = exportToken(token, Claims::getExpiration);
        return new Date().before(expiredDate);
    }


    public Key getKey(){
        byte[] byteKeys = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(byteKeys);
    }

    public Object getClaims(String token , String key){
        Claims claims = getClaims(token);
        return claims.get(key);
    }
}
