package ru.ygreens.todo.dto;

public record UserRegistrationDTO(
        String username,
        String email,
        String phone,
        String password,
        String secondPassword) {
}
