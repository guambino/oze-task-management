package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTypeServiceTest extends AbstractServiceTest {

    @Autowired
    private TaskTypeService taskTypeService;

    @Test
    public void listAllTaskTypes(){
        List<TaskTypeDto> taskTypes = taskTypeService.listAllTaskTypes();
        assertNotNull(taskTypes);

    }
}
