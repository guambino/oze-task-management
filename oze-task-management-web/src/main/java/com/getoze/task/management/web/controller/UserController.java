package com.getoze.task.management.web.controller;

import com.getoze.task.management.domain.dto.UserDto;
import com.getoze.task.management.domain.web.response.Response;
import com.getoze.task.management.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task/auth/user")
@Tag(name = "User API.", description = "Endpoints related for User.")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Registers a new User", description = "Registers a new User")
    public ResponseEntity<Response<String>> register(@RequestBody UserDto userDto) {
        Response<String> response = userService.createUser(userDto);
        return ResponseEntity.ok(response);
    }
}
