package com.getoze.task.management.repository;

import com.getoze.task.management.domain.repository.TaskComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskCommentRepository extends JpaRepository<TaskComment, UUID> {

    List<TaskComment> findByTaskId(UUID taskId);
}
