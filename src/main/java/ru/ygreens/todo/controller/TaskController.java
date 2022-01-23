package ru.ygreens.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import ru.ygreens.todo.dto.CreateTaskRequestDTO;
import ru.ygreens.todo.exception.FailedToCreateEntityException;
import ru.ygreens.todo.service.TaskService;

import java.util.UUID;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateTaskRequestDTO createTaskRequest) {
        var task = taskService.save(createTaskRequest);

        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }

        return ResponseEntity
                .badRequest()
                .body(new FailedToCreateEntityException("Failed to create entity"));
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestHeader(name = "id") String ID) {
        log.info(ID);
        return taskService.get(UUID.fromString(ID))
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Task is ID: %s, not found".formatted(ID)));
    }
}
