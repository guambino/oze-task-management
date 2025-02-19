package com.getoze.task.management.service.impl;

import com.getoze.task.management.domain.dto.UserDto;
import com.getoze.task.management.domain.repository.User;
import com.getoze.task.management.domain.web.response.Response;
import com.getoze.task.management.repository.UserRepository;
import com.getoze.task.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Response<String> createUser(UserDto userDto) {
        Response<String> response;

        //validate email
        if(userRepository.existsByEmail(userDto.getEmail())){
            response = new Response<>(Boolean.FALSE, "Email Already Exists");

        } else {
            User user = userRepository.save(getUser(userDto));
            response = new Response<>(Boolean.TRUE, String.format("User %s Created", user.getUserId()));
        }
        return response;
    }

    private User getUser(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }
}
