package com.example.damo.domains.group.dtos;


import com.example.damo.domains.group.entities.GroupInquiryReplyHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupRegisterInquiryReplyDto {
    private Long userId;
    private Long inquirerId;
    private Long groupId;
    private String contents;
    public GroupInquiryReplyHistory toEntity(){
        return GroupInquiryReplyHistory.builder()
                .userId(userId)
                .inquirerId(inquirerId)
                .groupId(groupId)
                .contents(contents)
                .build();
    }
}