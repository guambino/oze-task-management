package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.UserDto;
import com.getoze.task.management.domain.web.response.Response;

public interface UserService {

    Response<String> createUser(UserDto userDto);
}
