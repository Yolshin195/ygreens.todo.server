package ru.ygreens.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ygreens.todo.dto.UserRegistrationDTO;
import ru.ygreens.todo.entity.User;
import ru.ygreens.todo.exception.FailedToCreateEntityException;
import ru.ygreens.todo.repository.UserRepository;

@Service
public class UserServiceImp extends BaseEntityServiceImp<User, UserRepository> implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleService roleService;

    public UserServiceImp(UserRepository repository)
    {
        super(repository);
    }

    @Override
    public User createUser(UserRegistrationDTO userRegistrationDTO) {
        if (repository.existsByUsername(userRegistrationDTO.username())) {
            throw new FailedToCreateEntityException("A user with the same name already exists");
        }
        if (repository.existsByEmail(userRegistrationDTO.email())) {
            throw new FailedToCreateEntityException("A user with the same email already exists");
        }
        if (repository.existsByPhone(userRegistrationDTO.phone())) {
            throw new FailedToCreateEntityException("A user with the same phone already exists");
        }

        User user = new User();
        user.setUsername(userRegistrationDTO.username());
        user.setPhone(userRegistrationDTO.phone());
        user.setEmail(userRegistrationDTO.email());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

        user.setRole(roleService.getUserRole());

        return save(user).get();
    }
}
