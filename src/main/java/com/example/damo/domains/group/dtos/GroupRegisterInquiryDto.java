package com.example.damo.domains.group.dtos;

import com.example.damo.domains.group.entities.Group;
import com.example.damo.domains.group.entities.GroupInquiryHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupRegisterInquiryDto {
    private Long userId;
    private Long groupId;
    private String contents;

    public GroupInquiryHistory toEntity(){
        return GroupInquiryHistory.builder()
                .userId(userId)
                .groupId(groupId)
                .contents(contents)
                .build();
    }
}
