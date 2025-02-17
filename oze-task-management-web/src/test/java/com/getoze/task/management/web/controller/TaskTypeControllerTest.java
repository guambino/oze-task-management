package com.getoze.task.management.web.controller;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.service.TaskTypeService;
import com.getoze.task.management.web.AbstractWebTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TaskTypeControllerTest extends AbstractWebTest {

    @MockitoBean
    private TaskTypeService taskTypeService;

    @Test
    public void listAllTaskTypes()  throws Exception{
        when(taskTypeService.listAllTaskTypes()).thenReturn(List.of(getTaskTypeDto()));

        mockMvc.perform(get("/task/type")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    private TaskTypeDto getTaskTypeDto(){
        return TaskTypeDto.builder()
                .description("Bug")
                .taskTypeId("BUG")
                .build();
    }
}

