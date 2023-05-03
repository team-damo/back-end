package com.example.damo.domains.group_member.repositories;


import com.example.damo.domains.group_member.entities.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
}
