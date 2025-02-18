package com.getoze.task.management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6662188015345703625L;

    private String taskTypeId;

    private String description;
}
