package ru.ygreens.todo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ygreens.todo.entity.BaseEntity;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends PagingAndSortingRepository<E, UUID> {
    //Iterable<E> findAllByDelete_tsIsNull();

    //Optional<E> findByIdAndDelete_tsIsNull(UUID uuid);
}
