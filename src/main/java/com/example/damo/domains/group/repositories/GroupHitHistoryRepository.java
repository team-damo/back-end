package com.example.damo.domains.group.repositories;

import com.example.damo.domains.group.entities.GroupHitHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface GroupHitHistoryRepository  extends JpaRepository<GroupHitHistory, Long> {
}
