package com.getoze.task.management.domain.repository;

import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TASK", schema = "OZE")
public class Task extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -1185438709149262603L;

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID taskId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "TASK_DATE")
    private LocalDate taskDate;

    @Column(name = "COMPLETION_DATE")
    private LocalDate completionDate;

    @ManyToOne
    @JoinColumn(name = "TASK_TYPE_ID", updatable = false)
    private TaskType taskType;

    @OneToMany(mappedBy = "task")
    private Set<TaskComment> comments = new HashSet<>();

    public Task() {
    }

    public Task(TaskDto taskDto) {
        this.taskId = taskDto.getTaskId();
        this.title = taskDto.getTitle();
        this.description = taskDto.getDescription();
        this.taskDate = taskDto.getTaskDate();
        this.taskStatus = taskDto.getTaskStatus();
        this.taskType = new TaskType(taskDto.getTaskType());
        this.completionDate = taskDto.getCompletionDate();
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Set<TaskComment> getComments() {
        return comments;
    }

    public void setComments(Set<TaskComment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && taskStatus == task.taskStatus && Objects.equals(taskDate, task.taskDate) && Objects.equals(completionDate, task.completionDate) && Objects.equals(taskType, task.taskType) && Objects.equals(comments, task.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taskId, title, description, taskStatus, taskDate, completionDate, taskType, comments);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskDate=" + taskDate +
                ", completionDate=" + completionDate +
                ", taskType=" + taskType +
                ", comments=" + comments +
                '}';
    }
}
