package ru.ygreens.todo.repository;

import org.springframework.stereotype.Repository;
import ru.ygreens.todo.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByPhone(String phone);
}
