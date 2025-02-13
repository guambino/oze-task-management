package com.getoze.task.management.domain.repository;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TASK_TYPE", schema = "OZE")
public class TaskType extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -2053367427062580485L;

    @Id
    @Column(name = "TASK_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID taskTypeId;

    @Column(name = "DESCRIPTION")
    private String description;

    public UUID getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(UUID taskTypeId) {
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

    @Override
    public String toString() {
        return "TaskType{" +
                "taskTypeId=" + taskTypeId +
                ", description='" + description + '\'' +
                '}';
    }
}
