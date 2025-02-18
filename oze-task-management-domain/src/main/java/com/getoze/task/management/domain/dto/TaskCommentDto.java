package com.getoze.task.management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2853771117978313379L;

    private UUID taskCommentId;

    private UUID taskId;

    private String comment;
}
