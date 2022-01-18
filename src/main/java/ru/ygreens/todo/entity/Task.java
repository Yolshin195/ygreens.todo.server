package ru.ygreens.todo.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ygreens_todo_task")
@DynamicUpdate
public class Task extends BaseEntity {
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id", foreignKey = @ForeignKey(name = "FK_PARENT_ID"))
    private Task parent;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Task> children = new ArrayList<>();
}
