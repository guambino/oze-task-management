package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.UserDto;
import com.getoze.task.management.domain.web.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser(){
        Response<String> response = userService.createUser(getUserDto());
        assertNotNull(response);
        assertTrue(response.isSuccessful());

        response = userService.createUser(getUserDto());
        assertNotNull(response);
        assertFalse(response.isSuccessful());
    }

    private UserDto getUserDto(){
        return UserDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();
    }
}
