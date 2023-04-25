package com.example.damo.domains.group.repositories;

import com.example.damo.domains.group.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Long> {
}