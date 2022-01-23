package ru.ygreens.todo.dto;

import java.util.UUID;

public record CreateTaskRequestDTO(String title, String description, String parentId) {
}
