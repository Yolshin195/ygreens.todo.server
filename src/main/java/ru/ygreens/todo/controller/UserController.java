package ru.ygreens.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import ru.ygreens.todo.dto.ResponseMessageDTO;
import ru.ygreens.todo.dto.UserRegistrationDTO;
import ru.ygreens.todo.entity.User;
import ru.ygreens.todo.exception.FailedToCreateEntityException;
import ru.ygreens.todo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/singin")
    public void singIn() {

    }

    @PostMapping("/singup")
    public ResponseEntity<User> singUp(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        var user = userService.createUser(userRegistrationDTO);

        return ResponseEntity.ok(user);
    }
}
