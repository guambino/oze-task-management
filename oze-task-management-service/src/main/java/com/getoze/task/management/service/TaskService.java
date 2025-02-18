package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.web.request.UpdateTaskRequest;
import com.getoze.task.management.domain.web.response.Response;

import java.util.List;
import java.util.UUID;

public interface TaskService {


    Response<String> registerTask(TaskDto taskDto);

    Response<String> updateTask(TaskDto taskDto);

    Response<String> updateTask(UUID taskId, UpdateTaskRequest updateTaskRequest);

    Response<String> deleteTask(TaskDto taskDto);

    List<TaskDto> findAllTasks();
}
