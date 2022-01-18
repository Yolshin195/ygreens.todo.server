package ru.ygreens.todo.repository;

import org.springframework.stereotype.Repository;
import ru.ygreens.todo.entity.ERole;
import ru.ygreens.todo.entity.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role> {

    Optional<Role> findByName(ERole name);
}
