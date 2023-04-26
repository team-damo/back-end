package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupSaveDto;
import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupWriteService {
    private final GroupRepository groupRepository;

    public void create(GroupSaveDto groupSaveDto) {
        groupRepository.save(groupSaveDto.toEntity());
    }
}
