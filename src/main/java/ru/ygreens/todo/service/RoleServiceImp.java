package ru.ygreens.todo.service;

import org.springframework.stereotype.Service;
import ru.ygreens.todo.entity.ERole;
import ru.ygreens.todo.entity.Role;
import ru.ygreens.todo.repository.RoleRepository;

@Service
public class RoleServiceImp extends BaseEntityServiceImp<Role, RoleRepository> implements RoleService {
    protected RoleServiceImp(RoleRepository repository) {
        super(repository);
    }

    @Override
    public Role getUserRole() {
        return repository.findByName(ERole.ROLE_USER)
                .orElse(save(new Role(ERole.ROLE_USER)).get());
    }
}
