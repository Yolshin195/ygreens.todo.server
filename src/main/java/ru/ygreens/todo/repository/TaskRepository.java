package ru.ygreens.todo.repository;

import org.springframework.stereotype.Repository;
import ru.ygreens.todo.entity.Task;

@Repository
public interface TaskRepository extends BaseRepository<Task> {
}
