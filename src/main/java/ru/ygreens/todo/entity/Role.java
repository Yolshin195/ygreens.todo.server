package ru.ygreens.todo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "ygreens_todo_role")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role() {}

    public Role(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
