package com.aliyaman.deermind.controller;

import com.aliyaman.deermind.Jwt.AuthRequest;
import com.aliyaman.deermind.Jwt.AuthResponse;
import com.aliyaman.deermind.dto.DtoUser;

public interface IAuthController {
    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);
}
