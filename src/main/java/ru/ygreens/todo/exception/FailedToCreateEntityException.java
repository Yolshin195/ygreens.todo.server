package ru.ygreens.todo.exception;

public class FailedToCreateEntityException extends RuntimeException {
    public FailedToCreateEntityException(String message) {
        super(message);
    }
}
