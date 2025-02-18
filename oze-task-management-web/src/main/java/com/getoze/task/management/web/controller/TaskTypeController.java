package com.getoze.task.management.web.controller;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.web.response.Response;
import com.getoze.task.management.service.TaskTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task/type")
@Tag(name = "Task Type API.", description = "Endpoints related to Task Type.")
public class TaskTypeController {

    private final TaskTypeService taskTypeService;

    @Autowired
    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @GetMapping
    @Operation(summary = "Lists All Task Types", description = "Lists All Task Types")
    public ResponseEntity<Response<List<TaskTypeDto>>> listAllTaskTypes(){
        List<TaskTypeDto> taskTypeDtos = taskTypeService.listAllTaskTypes();
        Response<List<TaskTypeDto>> response = new Response<>(Boolean.TRUE, "Listed All", taskTypeDtos);
        return ResponseEntity.ok(response);
    }
}
