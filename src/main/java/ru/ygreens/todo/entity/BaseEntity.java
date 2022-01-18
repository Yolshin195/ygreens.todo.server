package ru.ygreens.todo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private int version;

    @Column(name = "create_ts", columnDefinition = "TIMESTAMP")
    private LocalDateTime createTs;
    @Column(name = "delete_ts", columnDefinition = "TIMESTAMP")
    private LocalDateTime deleteTs;
    @Column(name = "update_ts", columnDefinition = "TIMESTAMP")
    private LocalDateTime updateTs;

    @ManyToOne
    private User created_by;
    @ManyToOne
    private User updated_by;
    @ManyToOne
    private User deleted_by;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCreateTs() {
        return createTs;
    }

    public void setCreateTs(LocalDateTime createTs) {
        this.createTs = createTs;
    }

    public LocalDateTime getDeleteTs() {
        return deleteTs;
    }

    public void setDeleteTs(LocalDateTime deleteTs) {
        this.deleteTs = deleteTs;
    }

    public LocalDateTime getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(LocalDateTime updateTs) {
        this.updateTs = updateTs;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public User getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(User updated_by) {
        this.updated_by = updated_by;
    }

    public User getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(User deleted_by) {
        this.deleted_by = deleted_by;
    }
}
