package com.example.damo.application.usecases.groups.dtos;

import com.example.damo.domains.group_member.interfaces.GroupMemberInterface;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetGroupUseCaseDto {
    private Long id;
    private Long userId;
    private String type;
    private String name;
    private String introduction;
    private Integer maxUser;
    private Long currentUser;
    private Boolean isDone;
    private String deadlineAt;
    private String createdAt;
    private String deletedAt;
    private Long hit;
    private List<GroupMemberInterface> groupMembers;
    private Boolean isInquirer;
}
