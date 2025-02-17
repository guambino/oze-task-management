package com.getoze.task.management.repository;

import com.getoze.task.management.domain.repository.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, String> {
}
