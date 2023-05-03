package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupSaveJoinDto;
import com.example.damo.domains.group.repositories.GroupJoinHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupJoinHistoryWriteService {
    private final GroupJoinHistoryRepository groupJoinHistoryRepository;

    public void registerJoinMember(GroupSaveJoinDto groupSaveJoinDto) {
        groupJoinHistoryRepository.save(groupSaveJoinDto.toEntity());
    }

    public void remove(Long id) {
        groupJoinHistoryRepository.deleteById(id);
    }
}
