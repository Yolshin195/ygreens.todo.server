package ru.ygreens.todo.service;

import ru.ygreens.todo.dto.UserRegistrationDTO;
import ru.ygreens.todo.entity.User;

public interface UserService {
    User createUser(UserRegistrationDTO userRegistrationDTO);
}
