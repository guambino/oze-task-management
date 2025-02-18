package com.getoze.task.management.domain.web.request;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTaskRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7190822125730544639L;

    private String title;

    private String description;

    private TaskTypeDto taskType;
    
}
