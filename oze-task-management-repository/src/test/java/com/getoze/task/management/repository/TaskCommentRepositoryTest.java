package com.getoze.task.management.repository;

import com.getoze.task.management.domain.repository.Task;
import com.getoze.task.management.domain.repository.TaskComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskCommentRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private TaskCommentRepository taskCommentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void save(){
       Task task =  taskRepository.findAll().get(0);
       TaskComment taskComment = getTaskComment();
       taskComment.setTask(task);
       taskCommentRepository.save(taskComment);
       assertNotNull(taskComment.getTaskCommentId());
    }

    @Test
    public void delete(){
        Task task =  taskRepository.findAll().get(0);
        TaskComment taskComment = getTaskComment();
        taskComment.setTask(task);
        taskCommentRepository.save(taskComment);
        assertNotNull(taskComment.getTaskCommentId());

        taskCommentRepository.delete(taskComment);

    }

    @Test
    public void findByTaskId(){
        Task task =  taskRepository.findAll().get(0);
        List<TaskComment> comments = taskCommentRepository.findByTask(task);
        assertNotNull(comments);
    }


    private TaskComment getTaskComment() {
        TaskComment taskComment = new TaskComment();
        taskComment.setComment("This is a comment");

        return taskComment;
    }


}
