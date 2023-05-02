package com.example.damo.domains.group.dtos;

import com.example.damo.domains.group.entities.GroupJoinHistory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GroupSaveJoinDto {
    private Long userId;
    private Long groupId;
    private String message;
    private Integer status;

    public GroupJoinHistory toEntity(){
        return GroupJoinHistory.builder()
                .userId(userId)
                .groupId(groupId)
                .message(message)
                .build();
    }
}
