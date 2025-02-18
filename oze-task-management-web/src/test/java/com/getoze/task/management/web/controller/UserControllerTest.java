package com.getoze.task.management.web.controller;

import com.getoze.task.management.domain.dto.UserDto;
import com.getoze.task.management.service.UserService;
import com.getoze.task.management.web.AbstractWebTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends AbstractWebTest  {

    @MockitoBean
    private UserService userService;

    @Test
    public void register() throws Exception {
        when(userService.createUser(getUserDto())).thenReturn(getResponse("User Created...."));

        String requestBody = objectToJsonString(getUserDto());

        mockMvc.perform(post("/user/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

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
