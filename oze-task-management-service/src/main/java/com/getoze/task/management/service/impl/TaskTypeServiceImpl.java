package com.getoze.task.management.service.impl;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.repository.TaskType;
import com.getoze.task.management.repository.config.TaskTypeRepository;
import com.getoze.task.management.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {

    private final TaskTypeRepository repository;

    @Autowired
    public TaskTypeServiceImpl(TaskTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TaskTypeDto> listAllTaskTypes() {
        List<TaskTypeDto> taskTypeDtos = new ArrayList<>();

        repository.findAll().forEach(taskType -> taskTypeDtos.add(createTaskTypeDto(taskType)));

        return taskTypeDtos;
    }

    private TaskTypeDto createTaskTypeDto(TaskType taskType) {
        return TaskTypeDto.builder()
                .taskTypeId(taskType.getTaskTypeId())
                .description(taskType.getDescription())
                .build();
    }
}
