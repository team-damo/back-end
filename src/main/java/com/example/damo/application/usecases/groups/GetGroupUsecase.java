package com.example.damo.application.usecases.groups;

import com.example.damo.application.usecases.groups.dtos.GetGroupUsecaseDto;
import com.example.damo.domains.group.interfaces.GroupFindByIdInterface;
import com.example.damo.domains.group.services.GroupHitHistoryWriteService;
import com.example.damo.domains.group.services.GroupInquiryHistoryReadService;
import com.example.damo.domains.group.services.GroupReadService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class GetGroupUsecase {
    private final GroupReadService groupReadService;
    private final GroupInquiryHistoryReadService groupInquiryHistoryReadService;
    private final GroupHitHistoryWriteService groupHitHistoryWriteService;


    public GetGroupUsecaseDto getGroupWithIsInquirer(Long groupId, Long userId) {
        GroupFindByIdInterface group = groupReadService.findById(groupId);
        Boolean isInquirer = groupInquiryHistoryReadService.isInquirerOfGroup(groupId, userId);
        groupHitHistoryWriteService.increaseHitOfGroup(groupId, userId);
        return toDto(group, isInquirer);
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
