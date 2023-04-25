package com.example.damo.domains.group.dtos;

import com.example.damo.domains.group.entities.Group;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupDto {
    private Long id;
    private Long userId;
    private Integer typeId;
    private String name;
    private String introduction;
    private Integer maxUser;
    private Boolean isDone;
    private LocalDateTime deadlineAt;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    @Builder
    public GroupDto(Long id, Long userId, Integer typeId, String name, String introduction, Integer maxUser, Boolean isDone, LocalDateTime deadlineAt, LocalDateTime createdAt, LocalDateTime deletedAt) {
        this.id = id;
        this.userId = userId;
        this.typeId = typeId;
        this.name = name;
        this.introduction = introduction;
        this.maxUser = maxUser;
        this.isDone = isDone;
        this.deadlineAt = deadlineAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public Group toEntity(){
        return Group.builder()
                .id(id)
                .userId(userId)
                .typeId(typeId)
                .name(name)
                .introduction(introduction)
                .maxUser(maxUser)
                .isDone(isDone)
                .deadlineAt(deadlineAt)
                .createdAt(createdAt)
                .deletedAt(deletedAt)
                .build();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getMaxUser() {
        return maxUser;
    }
    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
    }

    public void setDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public LocalDateTime getDeadlineAt() {
        return deadlineAt;
    }
    public void setDeadlineAt(LocalDateTime deadlineAt) {
        this.deadlineAt = deadlineAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

}
