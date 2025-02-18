package com.getoze.task.management.domain.web.request;


import com.getoze.task.management.domain.dto.TaskCommentDto;
import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 7944064787286610888L;

    private String title;

    private String description;

    private TaskTypeDto taskType;

    private LocalDate completionDate;

    private TaskCommentDto taskComment;


}
