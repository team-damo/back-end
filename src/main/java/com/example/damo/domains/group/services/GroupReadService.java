package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupDto;
import com.example.damo.domains.group.entities.Group;
import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupReadService {
    private final GroupRepository groupRepository;

    public List<GroupDto> findAll(Integer type) {
         return groupRepository
                 .findAllByTypeIdOrderByCreatedAtDesc(type)
                 .stream()
                 .map(this::toDto)
                 .collect(Collectors.toList());
    }

    private GroupDto toDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getUserId(),
                group.getTypeId(),
                group.getName(),
                group.getIntroduction(),
                group.getMaxUser(),
                group.getIsDone(),
                group.getDeadlineAt(),
                group.getCreatedAt(),
                group.getDeletedAt()
        );
    }
}
