package ru.ygreens.todo.exception;

import java.util.Formatter;

public class FailedToCreateEntityException extends RuntimeException {
    public FailedToCreateEntityException(String message) {
        super(message);
    }
}
