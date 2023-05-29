package com.example.damo.domains.group.services;

import com.example.damo.domains.group.interfaces.GroupFindAllByReaderIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindByIdInterface;
import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupReadService {
    private final GroupRepository groupRepository;

    public Page<GroupFindAllByTypeIdInterface> findAll(Integer type, Pageable pageable) {
        return groupRepository.findAllByTypeId(type, pageable);
    }

    public GroupFindByIdInterface findById(Long id) {
        GroupFindByIdInterface group = groupRepository.findByIdWithHit(id);
        if(group == null) {
            throw new IllegalArgumentException("not found");
        }
        return group;
    }

    public List<GroupFindAllByReaderIdInterface> findAllInquiriesByReaderId(Long readerId) {
        return groupRepository.findAllInquiriesByReaderId(readerId);
    }

}
