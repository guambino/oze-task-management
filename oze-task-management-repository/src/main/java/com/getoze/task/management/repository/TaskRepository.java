package com.getoze.task.management.repository;

import com.getoze.task.management.domain.repository.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Override
    Optional<Task> findById(UUID uuid);

    @Override
    void deleteById(UUID uuid);
}
