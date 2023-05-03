package com.example.damo.domains.group.services;

import com.example.damo.domains.group.interfaces.GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface;
import com.example.damo.domains.group.repositories.GroupJoinHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupJoinHistoryReadService {
    private static final Integer DEFAULT_STATUS = 3;
    private final GroupJoinHistoryRepository groupJoinHistoryRepository;

    public List<GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface> getAllJoinMembersByGroupId(Long groupId) {
        return groupJoinHistoryRepository.findByGroupIdAndStatus(groupId, DEFAULT_STATUS);
    }
}
