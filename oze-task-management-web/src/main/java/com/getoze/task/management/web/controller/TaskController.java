package com.getoze.task.management.web.controller;

import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.web.request.RegisterTaskRequest;
import com.getoze.task.management.domain.web.request.UpdateTaskRequest;
import com.getoze.task.management.domain.web.response.Response;
import com.getoze.task.management.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@Tag(name = "Task API.", description = "Endpoints related to Task.")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    @Operation(summary = "Registers a new Task", description = "Registers a new Task")
    public ResponseEntity<Response<String>> registerTask(@RequestBody RegisterTaskRequest request) {
        Response<String> response = taskService.registerTask(getTaskDto(request));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{taskId}")
    @Operation(summary = "Updates a Task", description = "Updates a Task")
    public ResponseEntity<Response<String>> updateTask(@PathVariable("taskId") UUID taskId,
                                                       @RequestBody UpdateTaskRequest request ){
        Response<String> response = taskService.updateTask(taskId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{taskId:[a-z-]+}.{number:[\\d]+}")
    @Operation(summary = "Deletes a Task", description = "Deletes a Task")
    public ResponseEntity<Response<String>> deleteTask(@PathVariable("taskId") UUID taskId){
        Response<String> response = taskService.deleteTask(taskId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Lists All Task", description = "Lists All Task")
    public ResponseEntity<Response<List<TaskDto>>> findAllTasks() {
        List<TaskDto> tasks = taskService.findAllTasks();
        Response<List<TaskDto>> response = new Response<>(Boolean.TRUE, "Listed all Tasks", tasks);
        return ResponseEntity.ok(response);
    }

    private TaskDto getTaskDto(RegisterTaskRequest request) {
        return TaskDto.builder()
                .taskType(request.getTaskType())
                .taskDate(LocalDate.now())
                .title(request.getTitle())
                .taskStatus(TaskStatus.todo)
                .description(request.getDescription())
                .build();
    }


}
