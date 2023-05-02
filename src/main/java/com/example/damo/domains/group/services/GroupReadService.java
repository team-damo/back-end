package com.example.damo.domains.group.services;

import com.example.damo.domains.group.interfaces.GroupFindAllByReaderIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindByIdInterface;
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

    public GroupFindByIdInterface findById(Long id) {
        GroupFindByIdInterface group = groupRepository.findByIdWithHit(id);
        if(group == null) {
            throw new IllegalArgumentException("not found");
        }
        return group;
    }

    public List<GroupFindAllByReaderIdInterface> findAllInquiriesByReaderId(Long reader) {
        return groupRepository.findAllInquiriesByReaderId(reader);
    }
}
