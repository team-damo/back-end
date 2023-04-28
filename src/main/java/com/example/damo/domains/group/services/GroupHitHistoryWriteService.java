package com.example.damo.domains.group.services;

import com.example.damo.domains.group.entities.GroupHitHistory;
import com.example.damo.domains.group.repositories.GroupHitHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupHitHistoryWriteService {
    private final GroupHitHistoryRepository groupHitHistoryRepository;

    public void increaseHitOfGroup(Long groupId, Long userId) {
        groupHitHistoryRepository.save(GroupHitHistory
                .builder()
                .groupId(groupId)
                .userId(userId)
                .build()
        );
    }
}
