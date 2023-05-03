package com.example.damo.application.usecases.groups;

import com.example.damo.application.usecases.groups.dtos.GetGroupUsecaseDto;
import com.example.damo.application.usecases.groups.dtos.RegisterMemberDto;
import com.example.damo.domains.group.interfaces.GroupFindByIdInterface;
import com.example.damo.domains.group.services.*;
import com.example.damo.domains.group_member.services.GroupMemberWriteService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Data
@Service
public class GroupUseCase {
    private final GroupReadService groupReadService;
    private final GroupJoinHistoryWriteService groupJoinHistoryWriteService;
    private final GroupInquiryHistoryReadService groupInquiryHistoryReadService;
    private final GroupHitHistoryWriteService groupHitHistoryWriteService;
    private final GroupMemberWriteService groupMemberWriteService;


    public GetGroupUsecaseDto getGroupWithIsInquirer(Long groupId, Long userId) {
        GroupFindByIdInterface group = groupReadService.findById(groupId);
        Boolean isInquirer = groupInquiryHistoryReadService.isInquirerOfGroup(groupId, userId);
        groupHitHistoryWriteService.increaseHitOfGroup(groupId, userId);
        return toDto(group, isInquirer);
    }

    @Transactional
    public void registerMember(RegisterMemberDto registerMemberDto) {
        groupJoinHistoryWriteService.updateStatus(registerMemberDto.getJoinId());
        groupMemberWriteService.save(registerMemberDto.getGroupId(), registerMemberDto.getUserId());
    }

    private GetGroupUsecaseDto toDto(GroupFindByIdInterface group, Boolean isInquirer) {
        return new GetGroupUsecaseDto(
                group.getId(),
                group.getUser_Id(),
                group.getName(),
                group.getType(),
                group.getIntroduction(),
                group.getMax_User(),
                group.getIs_Done(),
                group.getDeadline_At(),
                group.getCreated_At(),
                group.getDeleted_At(),
                group.getHit(),
                isInquirer
        );
    }
}
