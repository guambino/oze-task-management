package com.getoze.task.management.domain.web.request;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTaskRequest {

    private String title;

    private String description;

    private TaskTypeDto taskType;

    private String comment;
}
