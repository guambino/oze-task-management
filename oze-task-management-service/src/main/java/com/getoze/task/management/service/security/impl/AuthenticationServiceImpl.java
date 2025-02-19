package com.getoze.task.management.service.security.impl;

import com.getoze.task.management.domain.dto.record.AuthenticationRequestDto;
import com.getoze.task.management.domain.dto.record.AuthenticationResponseDto;
import com.getoze.task.management.service.config.JwtTokenGenerator;
import com.getoze.task.management.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenGenerator tokenGenerator;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtTokenGenerator tokenGenerator) {
        this.authenticationManager = authenticationManager;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        final var authToken = UsernamePasswordAuthenticationToken.unauthenticated(request.username(), request.password());
        authenticationManager.authenticate(authToken);
        final var token = tokenGenerator.generateToken(request.username());
        return new AuthenticationResponseDto(token);
    }
}
