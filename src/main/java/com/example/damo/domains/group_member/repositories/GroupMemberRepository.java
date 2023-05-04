package com.example.damo.domains.group_member.repositories;


import com.example.damo.domains.group_member.entities.GroupMember;
import com.example.damo.domains.group_member.interfaces.GroupMemberInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMemberInterface> findAllByGroupId(Long groupId);
}
