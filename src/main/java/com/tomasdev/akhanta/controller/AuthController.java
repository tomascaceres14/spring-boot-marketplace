package com.tomasdev.akhanta.controller;

import com.tomasdev.akhanta.model.dto.AuthUserDTO;
import com.tomasdev.akhanta.model.dto.JwtResponseDTO;
import com.tomasdev.akhanta.model.dto.UserDTO;
import com.tomasdev.akhanta.model.dto.ResponseUserDTO;
import com.tomasdev.akhanta.service.AuthService;
import com.tomasdev.akhanta.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;
    private final AuthService authService;
    private final ModelMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDTO> save(@RequestBody UserDTO customer) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.map(service.registerUser(customer), ResponseUserDTO.class));
    }

    @PostMapping(path = "/sign-in")
    public ResponseEntity<JwtResponseDTO> signIn(@RequestBody @Valid AuthUserDTO authUserDTO) {
        return ResponseEntity.ok(authService.signIn(authUserDTO));
    }

    @PostMapping(path = "/sign-out")
    public ResponseEntity<String> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        authService.signOut(jwt);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("Signed out");
    }
}
