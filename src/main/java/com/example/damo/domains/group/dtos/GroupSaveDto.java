package com.example.damo.domains.group.dtos;

import com.example.damo.domains.group.entities.Group;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupSaveDto {
    private Long userId;
    private Integer typeId;
    private String name;
    private String introduction;
    private Integer maxUser;
    private LocalDateTime deadlineAt;

    public Group toEntity(){
        return Group.builder()
                .userId(userId)
                .typeId(typeId)
                .name(name)
                .introduction(introduction)
                .maxUser(maxUser)
                .deadlineAt(deadlineAt)
                .build();
    }
}
