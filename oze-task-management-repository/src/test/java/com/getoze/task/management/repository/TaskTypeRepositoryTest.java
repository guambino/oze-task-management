package com.getoze.task.management.repository;

import com.getoze.task.management.domain.repository.TaskType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTypeRepositoryTest extends AbstractRepositoryTest{

    @Autowired
    private TaskTypeRepository taskTypeRepository;

    @Test
    public void findAll() {
        List<TaskType> taskTypes = taskTypeRepository.findAll();
        assertNotNull(taskTypes);
        assertEquals(2, taskTypes.size(), "Wrong number of task types");
    }
}
