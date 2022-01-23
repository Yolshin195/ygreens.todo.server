package ru.ygreens.todo.service;

import ru.ygreens.todo.dto.CreateTaskRequestDTO;
import ru.ygreens.todo.entity.Task;

import java.util.Optional;

public interface TaskService extends BaseEntityService<Task> {
    Optional<Task> save(CreateTaskRequestDTO createTaskRequest);
}
