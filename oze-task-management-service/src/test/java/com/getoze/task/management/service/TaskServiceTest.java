package com.getoze.task.management.service;

import com.getoze.task.management.domain.dto.TaskCommentDto;
import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.web.request.UpdateTaskRequest;
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
    public void updateTask(){
        List<TaskDto> tasks = taskService.findAllTasks();
        TaskDto taskDto = tasks.get(0);

        taskDto.setTaskStatus(TaskStatus.in_progress);
        Response<String> response = taskService.updateTask(taskDto);
        assertNotNull(response);
    }

    @Test
    public void updateTaskWithRequest(){
        List<TaskDto> tasks = taskService.findAllTasks();
        TaskDto taskDto = tasks.get(0);

        Response<String> response = taskService.updateTask(taskDto.getTaskId(), getRequest());
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
        assertEquals(2, tasks.size(), "There should be one task");
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

    private UpdateTaskRequest getRequest(){
        UpdateTaskRequest request = new UpdateTaskRequest();
        request.setTaskComment(TaskCommentDto.builder().comment("Change the task").build());
        request.setTitle("New Title");
        request.setDescription("New Description");
        request.setCompletionDate(LocalDate.now());
        request.setTaskType(TaskTypeDto.builder().taskTypeId("TASK_TYPE_BUG").description("Bug").build());
        return request;

    }
}
