package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupSaveJoinDto;
import com.example.damo.domains.group.repositories.GroupJoinHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class GroupJoinHistoryWriteService {
    private static final Integer APPROVAL_STATUS = 1;
    private final GroupJoinHistoryRepository groupJoinHistoryRepository;

    public void registerJoinMember(GroupSaveJoinDto groupSaveJoinDto) {
        groupJoinHistoryRepository.save(groupSaveJoinDto.toEntity());
    }

    public void updateStatus(Long id) {
        int updateStatus = groupJoinHistoryRepository.updateStatusById(id, APPROVAL_STATUS, LocalDateTime.now());
        System.out.println(updateStatus);
    }
}
