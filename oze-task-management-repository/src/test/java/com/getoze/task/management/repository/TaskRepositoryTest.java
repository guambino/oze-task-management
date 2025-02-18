package com.getoze.task.management.repository;

import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.repository.Task;
import com.getoze.task.management.domain.repository.TaskComment;
import com.getoze.task.management.domain.repository.TaskType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void save(){
        Task task = taskRepository.save(getTask());
        assertNotNull(task.getTaskId());
    }

    @Test
    public void findAll(){
        List<Task> tasks = taskRepository.findAll();
        assertNotNull(tasks);
        assertEquals(1, tasks.size(), "The size of the tasks list should be 1");
    }

    @Test
    public void updateTask(){
        List<Task> tasks = taskRepository.findAll();
        Task task = tasks.get(0);
        task.setDescription("This is an update description");
        Task updatedTask = taskRepository.save(task);
        assertEquals(updatedTask.getTaskId(), task.getTaskId(), "The task id should be the same");
    }

    @Test
    public void deleteTask(){
        List<Task> tasks = taskRepository.findAll();
        Task task = tasks.get(0);

        //taskRepository.delete(task);

    }

    private Task getTask(){
        Task task = new Task();
        TaskType taskType = new TaskType();
        taskType.setTaskTypeId("TASK_TYPE_BUG");
        taskType.setDescription("Bug");
        task.setTaskType(taskType);
        task.setTitle("The Audit Trail listing is not working");
        task.setDescription("The listing of audit trail is coming up empty, but when we query the db there is data");
        task.setTaskDate(LocalDate.now());
        task.setTaskStatus(TaskStatus.todo);
        return task;
    }

}
