package com.aliyaman.deermind.service;

import com.aliyaman.deermind.Jwt.AuthRequest;
import com.aliyaman.deermind.Jwt.AuthResponse;
import com.aliyaman.deermind.dto.DtoUser;

public interface IAuthService {

    public AuthResponse authenticate(AuthRequest request);

    public DtoUser register(AuthRequest request);
}
