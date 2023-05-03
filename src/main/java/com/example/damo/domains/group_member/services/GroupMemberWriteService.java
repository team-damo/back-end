package com.example.damo.domains.group_member.services;


import com.example.damo.domains.group_member.entities.GroupMember;
import com.example.damo.domains.group_member.repositories.GroupMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupMemberWriteService {
    private final GroupMemberRepository groupMemberRepository;

    public void save(Long groupId, Long userId) {
        groupMemberRepository.save(new GroupMember(groupId, userId));
    }
}
