package com.example.damo.application.usecases.groups;

import com.example.damo.application.usecases.groups.dtos.GetGroupUsecaseDto;
import com.example.damo.domains.group.dtos.GroupFindByIdDto;
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
        GroupFindByIdDto group = groupReadService.findById(groupId);
        Boolean isInquirer = groupInquiryHistoryReadService.isInquirerOfGroup(groupId, userId);
        groupHitHistoryWriteService.increaseHitOfGroup(groupId, userId);
        return toDto(group, isInquirer);
    }

    private GetGroupUsecaseDto toDto(GroupFindByIdDto group, Boolean isInquirer) {
        return new GetGroupUsecaseDto(
                group.getId(),
                group.getUserId(),
                group.getName(),
                group.getName(),
                group.getIntroduction(),
                group.getMaxUser(),
                group.getIsDone(),
                group.getDeadlineAt(),
                group.getCreatedAt(),
                group.getDeletedAt(),
                isInquirer
        );
    }
}
