package com.example.damo.domains.group.repositories;


import com.example.damo.domains.group.entities.GroupJoinHistory;
import com.example.damo.domains.group.interfaces.GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

@EnableJpaRepositories
public interface GroupJoinHistoryRepository extends JpaRepository<GroupJoinHistory, Long> {
    List<GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface> findByGroupIdAndStatus(Long groupId, Integer status);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "UPDATE group_join_history gjh SET gjh.status = :status, gjh.updated_at = :updated_at WHERE gjh.id = :id")
    int updateStatusById(@Param("id") Long id, @Param("status") Integer status, @Param("updated_at") LocalDateTime updatedAt);
}
