package com.example.damo.domains.group.repositories;


import com.example.damo.domains.group.entities.GroupJoinHistory;
import com.example.damo.domains.group.interfaces.GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface GroupJoinHistoryRepository extends JpaRepository<GroupJoinHistory, Long> {
    List<GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface> findByGroupIdAndStatus(Long groupId, Integer status);
}
