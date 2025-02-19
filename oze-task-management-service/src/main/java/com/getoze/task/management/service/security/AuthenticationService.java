package com.getoze.task.management.service.security;

import com.getoze.task.management.domain.dto.record.AuthenticationRequestDto;
import com.getoze.task.management.domain.dto.record.AuthenticationResponseDto;

public interface AuthenticationService {

    AuthenticationResponseDto authenticate(final AuthenticationRequestDto request);
}
