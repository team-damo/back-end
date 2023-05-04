package com.example.damo.application.usecases.groups;

import com.example.damo.application.usecases.groups.dtos.GetGroupUseCaseDto;
import com.example.damo.application.usecases.groups.dtos.RegisterMemberDto;
import com.example.damo.domains.group.interfaces.GroupFindByIdInterface;
import com.example.damo.domains.group.services.*;
import com.example.damo.domains.group_member.interfaces.GroupMemberInterface;
import com.example.damo.domains.group_member.services.GroupMemberReadService;
import com.example.damo.domains.group_member.services.GroupMemberWriteService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
public class GroupUseCase {
    private final GroupReadService groupReadService;
    private final GroupJoinHistoryWriteService groupJoinHistoryWriteService;
    private final GroupInquiryHistoryReadService groupInquiryHistoryReadService;
    private final GroupHitHistoryWriteService groupHitHistoryWriteService;
    private final GroupMemberWriteService groupMemberWriteService;
    private final GroupMemberReadService groupMemberReadService;


    public GetGroupUseCaseDto getGroupWithIsInquirer(Long groupId, Long userId) {
        GroupFindByIdInterface group = groupReadService.findById(groupId);
        List<GroupMemberInterface> groupMembers = groupMemberReadService.findAllByGroupId(groupId);
        Boolean isInquirer = groupInquiryHistoryReadService.isInquirerOfGroup(groupId, userId);
        groupHitHistoryWriteService.increaseHitOfGroup(groupId, userId);
        return toDto(group, groupMembers, isInquirer);
    }

    @Transactional
    public void registerMember(RegisterMemberDto registerMemberDto) {
        groupJoinHistoryWriteService.updateStatus(registerMemberDto.getJoinId());
        groupMemberWriteService.save(registerMemberDto.getGroupId(), registerMemberDto.getUserId());
    }

    private GetGroupUseCaseDto toDto(GroupFindByIdInterface group, List<GroupMemberInterface> groupMembers, Boolean isInquirer) {
        return new GetGroupUseCaseDto(
                group.getId(),
                group.getUser_Id(),
                group.getName(),
                group.getType(),
                group.getIntroduction(),
                group.getMax_User(),
                (long) groupMembers.size(),
                group.getIs_Done(),
                group.getDeadline_At(),
                group.getCreated_At(),
                group.getDeleted_At(),
                group.getHit(),
                groupMembers,
                isInquirer
        );
    }
}
