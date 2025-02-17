package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.web.response.Response;

import java.util.List;

public interface TaskService {


    Response<String> registerTask(TaskDto taskDto);

    Response<String> updateTask(TaskDto taskDto);

    Response<String> deleteTask(TaskDto taskDto);

    List<TaskDto> findAllTasks();
}
