package com.example.damo.domains.group_member.services;

import com.example.damo.domains.group_member.interfaces.GroupMemberInterface;
import com.example.damo.domains.group_member.repositories.GroupMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupMemberReadService {
    private final GroupMemberRepository groupMemberRepository;

    public List<GroupMemberInterface> findAllByGroupId(Long groupId) {
        return groupMemberRepository.findAllByGroupId(groupId);
    }
}
