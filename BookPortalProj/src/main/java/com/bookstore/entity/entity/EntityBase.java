package com.bookstore.entity.entity;

import javax.persistence.*;
import java.util.*;
@MappedSuperclass
public class EntityBase {
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name="OPERATION_TYPE")
    private String operationType;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public boolean isActive() {
        return active;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    public void onPrePersist(){
        this.setActive(true);
        this.setCreateDate(new Date());
        this.setUpdateDate(new Date());
        this.setOperationType("SAVE");
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setUpdateDate(new Date());
        this.setCreateDate(new Date());
        this.setUpdateDate(new Date());
        this.setOperationType("SAVE");
    }


    @PreRemove
    public void onPreRemove() {
        this.setUpdateDate(new Date());
        this.setOperationType("DELETE");
    }





}