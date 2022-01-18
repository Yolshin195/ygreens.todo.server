package ru.ygreens.todo.service;

import ru.ygreens.todo.entity.BaseEntity;

import java.util.Optional;
import java.util.UUID;

public interface BaseEntityService<E extends BaseEntity> {
    Iterable<E> getAll();
    Optional<E> get(UUID id);
    Optional<E> save(E entity);
    Optional<E> update(E entity);
    Boolean deleteById(UUID id);
}
