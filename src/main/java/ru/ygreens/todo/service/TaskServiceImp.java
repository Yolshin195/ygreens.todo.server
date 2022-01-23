package ru.ygreens.todo.service;

import org.springframework.stereotype.Service;
import ru.ygreens.todo.dto.CreateTaskRequestDTO;
import ru.ygreens.todo.entity.Task;
import ru.ygreens.todo.exception.FailedToCreateEntityException;
import ru.ygreens.todo.repository.TaskRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImp extends BaseEntityServiceImp<Task, TaskRepository> implements TaskService{
    protected TaskServiceImp(TaskRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Task> save(CreateTaskRequestDTO createTaskRequest) {

        Task task = new Task();
        task.setTitle(createTaskRequest.title());
        task.setDescription(createTaskRequest.description());

        if (createTaskRequest.parentId() != null) {
            Task parent = repository.findById(UUID.fromString(createTaskRequest.parentId()))
                    .orElseThrow(() -> {
                        var message = "Task parent is UUID %s, not found".formatted(createTaskRequest.parentId());
                        return new FailedToCreateEntityException(message);
                    });
            task.setParent(parent);
        }

        return super.save(task);
    }
}
