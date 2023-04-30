package com.example.damo.domains.group.services;

import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
import com.example.damo.domains.group.dtos.GroupFindByIdDto;
import com.example.damo.domains.group.entities.Group;
import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupReadService {
    private final GroupRepository groupRepository;

    public List<GroupFindAllByTypeIdInterface> findAll(Integer type) {
         return groupRepository.findAllByTypeId(type);
    }

    public GroupFindByIdDto findById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        return toIdDto(group);
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
