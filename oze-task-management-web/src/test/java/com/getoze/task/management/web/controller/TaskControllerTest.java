package com.getoze.task.management.web.controller;

import com.getoze.task.management.domain.dto.TaskCommentDto;
import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.web.request.RegisterTaskRequest;
import com.getoze.task.management.domain.web.request.UpdateTaskRequest;
import com.getoze.task.management.service.TaskService;
import com.getoze.task.management.web.AbstractWebTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TaskControllerTest extends AbstractWebTest {

    @MockitoBean
    private TaskService taskService;

    @Test
    public void registerTask() throws Exception {
        when(taskService.registerTask(getTaskDto())).thenReturn(getResponse("Registered"));

        String requestBody = objectToJsonString(getRegisterTaskRequest());

        mockMvc.perform(post("/task/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void updateTask() throws Exception {
        when(taskService.updateTask(getTaskDto())).thenReturn(getResponse("Updated"));

        String requestBody = objectToJsonString(getUpdateTaskRequest());

        mockMvc.perform(put("/task/update/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void deleteTask() throws Exception {
        when(taskService.deleteTask(any(UUID.class))).thenReturn(getResponse("Deleted"));

        String requestBody = objectToJsonString(getTaskDto());

        mockMvc.perform(delete("/task/delete/"  + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void findAllTasks() throws Exception {
        when(taskService.findAllTasks()).thenReturn(List.of(getTaskDto()));

        mockMvc.perform(get("/task")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }


    private TaskDto getTaskDto(){
        return TaskDto.builder()
                .taskId(UUID.randomUUID())
                .title("Some Title")
                .description("Some Description")
                .taskStatus(TaskStatus.todo)
                .taskDate(LocalDate.now())
                .taskType(TaskTypeDto.builder().taskTypeId("TASK_TYPE_BUG").description("Bug").build())
                .build();
    }

    private RegisterTaskRequest getRegisterTaskRequest(){
        RegisterTaskRequest registerTaskRequest = new RegisterTaskRequest();
        registerTaskRequest.setTaskType(TaskTypeDto.builder().taskTypeId("BUG").build());
        registerTaskRequest.setTitle("Title");
        registerTaskRequest.setDescription("Description");
        return registerTaskRequest;
    }

    private UpdateTaskRequest getUpdateTaskRequest(){
        UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
        updateTaskRequest.setTaskType(TaskTypeDto.builder().taskTypeId("BUG").build());
        updateTaskRequest.setTitle("Title");
        updateTaskRequest.setDescription("Description");
        updateTaskRequest.setTaskComment(TaskCommentDto.builder().comment("New Comment").build());
        return updateTaskRequest;
    }
}
