package com.getoze.task.management.service.impl;

import com.getoze.task.management.domain.dto.TaskCommentDto;
import com.getoze.task.management.domain.dto.TaskDto;
import com.getoze.task.management.domain.dto.TaskTypeDto;
import com.getoze.task.management.domain.enums.TaskStatus;
import com.getoze.task.management.domain.repository.Task;
import com.getoze.task.management.domain.repository.TaskComment;
import com.getoze.task.management.domain.web.request.UpdateTaskRequest;
import com.getoze.task.management.domain.web.response.Response;
import com.getoze.task.management.repository.TaskCommentRepository;
import com.getoze.task.management.repository.TaskRepository;
import com.getoze.task.management.service.TaskService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskCommentRepository taskCommentRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskCommentRepository taskCommentRepository) {
        this.taskRepository = taskRepository;
        this.taskCommentRepository = taskCommentRepository;
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
    public Response<String> updateTask(UUID taskId, UpdateTaskRequest updateTaskRequest) {

        //validate id
        Optional<Task> existingTask = taskRepository.findById(taskId);

        if(existingTask.isPresent()){
            TaskDto taskDto = TaskDto.builder()
                    .taskId(taskId)
                    .taskComment(updateTaskRequest.getTaskComment())
                    .completionDate(updateTaskRequest.getCompletionDate())
                    .taskType(updateTaskRequest.getTaskType())
                    .title(updateTaskRequest.getTitle())
                    .description(updateTaskRequest.getDescription())
                    .build();
            return updateTask(taskDto);
        }

        String message = String.format("Task with id %s does not exist", taskId);
        return new Response<>(Boolean.FALSE, message );
    }

    @Override
    public Response<String> updateTask(TaskDto taskDto) {

        try{
            //Update Status accordingly
            if(null == taskDto.getCompletionDate()){
                //Task has started
                taskDto.setTaskStatus(TaskStatus.in_progress);
            }else{
                //Task is completed
                taskDto.setTaskStatus(TaskStatus.completed);
            }

            Task task = taskRepository.save(new Task(taskDto));

            //Update or Create Comments if there is any
            if(null != taskDto.getTaskComment()){
                TaskCommentDto taskCommentDto = taskDto.getTaskComment();
                taskCommentRepository.save(new TaskComment(taskCommentDto.getTaskCommentId(), task, taskCommentDto.getComment()));
            }
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
            Task task = new Task(taskDto);

            List<TaskComment> comments = taskCommentRepository.findByTask(task);

            if(null != comments && !(comments.isEmpty())){
                taskCommentRepository.deleteAll(comments);
            }
            taskRepository.delete(task);
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
