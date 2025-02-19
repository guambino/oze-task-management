package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.UserDto;
import com.getoze.task.management.domain.web.response.Response;

import java.util.List;

public interface UserService {

    Response<String> createUser(UserDto userDto);

    List<UserDto> getAllUsers();
}
