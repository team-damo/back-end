package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupDto;
import com.example.damo.domains.group.entities.Group;
import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupWriteService {
    private final GroupRepository groupRepository;

    public void create(GroupDto groupDto) {
        Group group = groupDto.toEntity();
        System.out.println(group.getId());
        System.out.println(group.getIntroduction());
        System.out.println(group.getUserId());
        System.out.println(group.getTypeId());
        System.out.println(group.getName());
        System.out.println(group.getDeadlineAt());
        System.out.println(group.getDeletedAt());
        System.out.println(group.getCreatedAt());
        System.out.println(group.getIsDone());
        System.out.println(group.getMaxUser());
        groupRepository.save(group);
    }
}
