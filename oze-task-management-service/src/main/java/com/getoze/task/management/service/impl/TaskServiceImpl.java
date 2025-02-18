package com.getoze.task.management.service.impl;

import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.repository.Task;
import com.getoze.task.management.domain.web.response.Response;
import com.getoze.task.management.repository.TaskRepository;
import com.getoze.task.management.service.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Response<String> registerTask(TaskDto taskDto) {

        try{
            taskRepository.save(new Task(taskDto));
            return new Response<>(Boolean.TRUE, "Task registered successfully");
        }catch (Exception ex){
            String message = String.format("Error update a task  %s", ex.getMessage());
            log.error(message);
            return new Response<>(Boolean.FALSE, message);
        }

    }

    @Override
    public Response<String> updateTask(TaskDto taskDto) {

        try{
            taskRepository.save(new Task(taskDto));
            return new Response<>(Boolean.TRUE, "Task updated successfully");
        }catch (Exception ex){
            String message = String.format("Error update a task  %s", ex.getMessage());
            log.error(message);
            return new Response<>(Boolean.FALSE, message);
        }

    }

    @Override
    public Response<String> deleteTask(TaskDto taskDto) {

        try{
            taskRepository.delete(new Task(taskDto));
            return new Response<>(Boolean.TRUE, "Task deleted successfully");
        }catch (Exception ex){
            String message = String.format("Error deleting a task  %s", ex.getMessage());
            log.error(message);
            return new Response<>(Boolean.FALSE, message);
        }

    }

    @Override
    public List<TaskDto> findAllTasks() {
        List<TaskDto> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(task -> tasks.add(createTaskDto(task)));
        return tasks;
    }


    private TaskDto createTaskDto(Task task) {
        return TaskDto.builder()
                .taskId(task.getTaskId())
                .taskStatus(task.getTaskStatus())
                .taskDate(task.getTaskDate())
                .taskType(TaskTypeDto.builder().taskTypeId(task.getTaskType().getTaskTypeId()).description(task.getTaskType().getDescription()).build())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }
}
