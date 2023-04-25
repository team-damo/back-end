package com.example.damo.domains.group.dtos;

import com.example.damo.domains.group.entities.Group;
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
}
