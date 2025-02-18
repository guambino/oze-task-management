package com.getoze.task.management.domain.repository;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TASK_COMMENT", schema = "OZE")
public class TaskComment extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -735202425393727973L;

    @Id
    @Column(name = "TASK_COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID taskCommentId;

    @ManyToOne
    @JoinColumn(name = "TASK_ID", updatable = false)
    private Task task;

    @Column(name = "COMMENT")
    private String comment;

    public UUID getTaskCommentId() {
        return taskCommentId;
    }

    public void setTaskCommentId(UUID taskCommentId) {
        this.taskCommentId = taskCommentId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaskComment that = (TaskComment) o;
        return Objects.equals(taskCommentId, that.taskCommentId) && Objects.equals(task, that.task) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taskCommentId, task, comment);
    }

    @Override
    public String toString() {
        return "TaskComment{" +
                "taskCommentId=" + taskCommentId +
                ", task=" + task +
                ", comment='" + comment + '\'' +
                '}';
    }
}
