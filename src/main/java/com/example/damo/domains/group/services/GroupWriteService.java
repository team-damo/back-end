package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupRegisterInquiryDto;
import com.example.damo.domains.group.dtos.GroupRegisterInquiryReplyDto;
import com.example.damo.domains.group.dtos.GroupSaveDto;
import com.example.damo.domains.group.repositories.GroupInquiryHistoryRepository;
import com.example.damo.domains.group.repositories.GroupInquiryReplyHistoryRepository;
import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupWriteService {
    private final GroupRepository groupRepository;
    private final GroupInquiryHistoryRepository groupInquiryHistoryRepository;
    private final GroupInquiryReplyHistoryRepository groupInquiryReplyHistoryRepository;

    public void create(GroupSaveDto groupSaveDto) {
        groupRepository.save(groupSaveDto.toEntity());
    }

    public void registerInquiry(GroupRegisterInquiryDto groupRegisterInquiryDto) {
        groupInquiryHistoryRepository.save(groupRegisterInquiryDto.toEntity());
    }
    public void registerInquiryReply(GroupRegisterInquiryReplyDto groupRegisterInquiryReplyDto) {
        groupInquiryReplyHistoryRepository.save(groupRegisterInquiryReplyDto.toEntity());
    }
}
