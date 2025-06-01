package com.tomasdev.akhanta.auth;

import com.tomasdev.akhanta.auth.dto.LogInCredentialsDTO;
import com.tomasdev.akhanta.security.jwt.JwtResponseDTO;
import com.tomasdev.akhanta.auth.dto.UserRegisterDTO;

public interface AuthService {

    JwtResponseDTO registerUser(UserRegisterDTO customerDTO);

    JwtResponseDTO logIn(LogInCredentialsDTO credentials);

    JwtResponseDTO refreshAccessToken(String refreshToken);
    void signOut(String jwt);


}
