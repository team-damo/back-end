package com.example.damo.domains.group.services;

import com.example.damo.domains.group.repositories.GroupInquiryHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupInquiryHistoryReadService {
    private final GroupInquiryHistoryRepository groupInquiryHistoryRepository;

    public Boolean isInquirerOfGroup(Long groupId, Long userId) {
        return groupInquiryHistoryRepository.findByGroupIdAndUserId(groupId, userId).isPresent();
    }
}
