package com.example.damo.domains.group.repositories;

import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
import com.example.damo.domains.group.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query(nativeQuery = true,
            value = "SELECT g.*, gt.name as type, IFNULL(gh.count, 0) AS hit FROM `groups` g " +
        "LEFT JOIN group_types gt ON g.type_id = gt.id " +
        "LEFT JOIN (SELECT h.group_id, COUNT(*) AS count FROM group_hit_history h GROUP BY h.group_id) AS gh " +
        "ON gh.group_id = g.id " +
        "WHERE g.type_id = ? " +
        "ORDER BY created_at DESC"
    )
    List<GroupFindAllByTypeIdInterface> findAllByTypeId(Integer type);
}