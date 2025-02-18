package com.getoze.task.management.domain.dto;

import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.repository.TaskType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable  {

    @Serial
    private static final long serialVersionUID = -7606645645729580367L;

    private UUID taskId;

    private String title;

    private String description;

    private TaskStatus taskStatus;

    private LocalDate taskDate;

    private TaskTypeDto taskType;

    private LocalDate completionDate;

    private List<TaskCommentDto> taskComments = new ArrayList<>();
}
