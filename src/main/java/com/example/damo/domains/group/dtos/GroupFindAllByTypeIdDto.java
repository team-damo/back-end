package com.example.damo.domains.group.dtos;

import com.example.damo.domains.group.entities.GroupType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupFindAllByTypeIdDto {
    private Long id;
    private Long userId;
    private String type;
    private String name;
    private String introduction;
    private Integer maxUser;
    private Boolean isDone;
    private LocalDateTime deadlineAt;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
