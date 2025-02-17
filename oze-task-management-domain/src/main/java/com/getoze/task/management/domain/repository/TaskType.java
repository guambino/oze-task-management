package com.getoze.task.management.domain.repository;

import com.getoze.task.management.domain.dto.TaskTypeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.util.Objects;

@Entity
@Table(name = "TASK_TYPE", schema = "OZE")
public class TaskType extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -2053367427062580485L;

    @Id
    @Column(name = "TASK_TYPE_ID")
    private String taskTypeId;

    @Column(name = "DESCRIPTION")
    private String description;

    public TaskType() {
    }

    public TaskType(String taskTypeId, String description) {
        this.taskTypeId = taskTypeId;
        this.description = description;
    }

    public TaskType(TaskTypeDto taskTypeDto){
        this(taskTypeDto.getTaskTypeId(),taskTypeDto.getDescription());
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaskType taskType = (TaskType) o;
        return Objects.equals(taskTypeId, taskType.taskTypeId) && Objects.equals(description, taskType.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taskTypeId, description);
    }
}
