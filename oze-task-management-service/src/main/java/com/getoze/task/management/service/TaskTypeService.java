package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.TaskTypeDto;

import java.util.List;

public interface TaskTypeService {

    List<TaskTypeDto> listAllTaskTypes();
}
