package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.web.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest extends AbstractServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void registerTask(){
        Response<String> response = taskService.registerTask(getTaskDto());
        assertNotNull(response);
        assertTrue(response.isSuccessful());
    }

    @Test
    public void registerTaskException(){
        TaskDto taskDto = getTaskDto();
        taskDto.setTitle(null);

        Response<String> response = taskService.registerTask(taskDto);
        assertNotNull(response);
        assertFalse(response.isSuccessful());

    }

    @Test
    public void updateTask(){
        List<TaskDto> tasks = taskService.findAllTasks();
        TaskDto taskDto = tasks.get(0);

        taskDto.setTaskStatus(TaskStatus.in_progress);
        Response<String> response = taskService.updateTask(taskDto);
        assertNotNull(response);
    }

    @Test
    public void updateTaskException(){
        List<TaskDto> tasks = taskService.findAllTasks();
        TaskDto taskDto = tasks.get(0);

        taskDto.setTitle(null);
        Response<String> response = taskService.updateTask(taskDto);
        assertNotNull(response);


    }

    @Test
    public void deleteTask(){
        List<TaskDto> tasks = taskService.findAllTasks();
        TaskDto taskDto = tasks.get(0);

        Response<String> response = taskService.deleteTask(taskDto);
        assertNotNull(response);
        assertTrue(response.isSuccessful());

    }

    @Test
    public void deleteTaskException(){
        List<TaskDto> tasks = taskService.findAllTasks();
        TaskDto taskDto = tasks.get(0);

        taskDto.setTaskId(null);
        Response<String> response = taskService.deleteTask(taskDto);
        assertNotNull(response);

    }

    @Test
    public void findAllTasks(){
        List<TaskDto> tasks = taskService.findAllTasks();
        assertNotNull(tasks);
        assertEquals(1, tasks.size(), "There should be one task");
    }


    private TaskDto getTaskDto(){
        return TaskDto.builder()
                .title("Some Title")
                .description("Some Description")
                .taskStatus(TaskStatus.todo)
                .taskDate(LocalDate.now())
                .taskType(TaskTypeDto.builder().taskTypeId("TASK_TYPE_BUG").description("Bug").build())
                .build();
    }
}
