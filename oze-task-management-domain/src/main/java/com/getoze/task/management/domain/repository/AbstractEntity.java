package com.getoze.task.management.domain.repository;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 9151535622222718347L;

    @Column(name = "CREATE_USER")
    protected String createUser;

    @Column(name = "CREATE_DATE")
    protected LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "LAST_UPDATE_USER")
    protected String lastUpdateUser;

    @Column(name = "LAST_UPDATE_DATE")
    protected LocalDateTime lastUpdateDate = LocalDateTime.now();

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(createUser, that.createUser) && Objects.equals(createDate, that.createDate) && Objects.equals(lastUpdateUser, that.lastUpdateUser) && Objects.equals(lastUpdateDate, that.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createUser, createDate, lastUpdateUser, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateUser='" + lastUpdateUser + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
