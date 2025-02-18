package com.getoze.task.management.service;

import com.getoze.task.management.domain.repository.TaskComment;
import com.getoze.task.management.repository.TaskCommentRepository;
import com.getoze.task.management.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskCommentRepositoryTest extends AbstractServiceTest {

    @Autowired
    private TaskCommentRepository taskCommentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void findByTaskId(){
        List<TaskComment> taskComments = taskCommentRepository.findByTaskId(taskRepository.findAll().get(0).getTaskId());
        assertNotNull(taskComments);
    }
}
