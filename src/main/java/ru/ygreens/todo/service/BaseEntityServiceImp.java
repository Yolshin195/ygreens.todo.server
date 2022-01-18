package ru.ygreens.todo.service;

import ru.ygreens.todo.entity.BaseEntity;
import ru.ygreens.todo.repository.BaseRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseEntityServiceImp<E extends BaseEntity, R extends BaseRepository<E>> implements BaseEntityService<E> {
    protected final R repository;

    protected BaseEntityServiceImp(R repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<E> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> get(UUID id) {
        return repository.findById(id).map(e -> (e.getDeleteTs() == null) ? e : null);
    }

    @Override
    public Optional<E> save(E entity) {
        entity.setCreateTs(LocalDateTime.now());
        entity.setDeleteTs(null);
        entity.setUpdateTs(null);
        entity.setDeleted_by(null);
        entity.setUpdated_by(null);
        entity.setVersion(1);

        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<E> update(E entity) {
        return repository.findById(entity.getId())
                .map(currentEntity -> {
                    if (currentEntity.getVersion() == entity.getVersion()) {
                        entity.setVersion(entity.getVersion() + 1);
                        entity.setUpdateTs(LocalDateTime.now());
                        return repository.save(entity);
                    }

                    return null;
                });
    }

    @Override
    public Boolean deleteById(UUID id) {
        return get(id)
                .map(e -> {
                    if (e.getDeleteTs() == null) {
                        e.setDeleteTs(LocalDateTime.now());
                        repository.save(e);

                        return true;
                    }

                    return false;
                })
                .orElse(false);

    }
}
