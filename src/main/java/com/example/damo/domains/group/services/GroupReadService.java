package com.example.damo.domains.group.services;

import com.example.damo.domains.group.dtos.GroupFindAllByTypeIdDto;
import com.example.damo.domains.group.dtos.GroupFindByIdDto;
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

    public List<GroupFindAllByTypeIdDto> findAll(Integer type) {
         return groupRepository
                 .findAllByTypeIdOrderByCreatedAtDesc(type)
                 .stream()
                 .map(this::toTypeIdDto)
                 .collect(Collectors.toList());
    }

    public GroupFindByIdDto findById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        return toIdDto(group);
    }

    private GroupFindAllByTypeIdDto toTypeIdDto(Group group) {
        return new GroupFindAllByTypeIdDto(
                group.getId(),
                group.getUserId(),
                group.getGroupType().getName(),
                group.getName(),
                group.getIntroduction(),
                group.getMaxUser(),
                group.getIsDone(),
                group.getDeadlineAt(),
                group.getCreatedAt(),
                group.getDeletedAt()
        );
    }
    private GroupFindByIdDto toIdDto(Group group) {
        return new GroupFindByIdDto(
                group.getId(),
                group.getUserId(),
                group.getGroupType().getName(),
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
