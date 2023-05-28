package com.example.damo.domains.group.repositories;

import com.example.damo.domains.group.interfaces.GroupFindAllByReaderIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
import com.example.damo.domains.group.entities.Group;
import com.example.damo.domains.group.interfaces.GroupFindByIdInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query(nativeQuery = true,
            value =
        "SELECT g.id AS id, g.user_id AS userId, g.type_id AS typeId, g.name AS name, g.introduction as introduction, g.max_user as maxUser, g.is_done AS isDone, g.deadline_at AS deadlineAt, g.created_at AS createdAt, gt.name AS type, IFNULL(COUNT(g.id), 0) AS hit FROM `groups` g " +
        "LEFT JOIN group_types gt ON g.type_id = gt.id " +
        "LEFT JOIN group_hit_history gh ON gh.group_id = g.id " +
        "GROUP BY g.id " +
        "HAVING g.type_id = :type"
    )
    Page<GroupFindAllByTypeIdInterface> findAllByTypeId(@Param("type") Integer type, Pageable pageable);

    @Query(nativeQuery = true,
            value = "SELECT g.*, gt.name as type, IFNULL(gh.count, 0) AS hit FROM `groups` g " +
        "LEFT JOIN group_types gt ON g.type_id = gt.id " +
        "LEFT JOIN (SELECT h.group_id, COUNT(*) AS count FROM group_hit_history h GROUP BY h.group_id) AS gh " +
        "ON gh.group_id = g.id " +
        "WHERE g.id = ? ")
    GroupFindByIdInterface findByIdWithHit(Long id);

    @Query(nativeQuery = true,
    value =
    "SELECT g.id, g.created_at AS createdAt, g.is_done AS isDone, g.max_user AS maxUser, g.name, gt.name AS `type`, gih.contents AS inquiryContents, gih.user_id AS inquirerId, gih.created_at AS inquiryCreatedAt, gi.unread_inquiries AS unreadInquiries FROM `groups` g " +
    "INNER JOIN group_inquiry_history gih ON gih.group_id = g.id " +
    "INNER JOIN " +
    "(SELECT group_id, user_id, SUM(is_checked = 0) as unread_inquiries, MAX(created_at) as latest_created_at " +
    "FROM group_inquiry_history " +
    "GROUP BY group_id, user_id) gi " +
    "ON gi.group_id = g.id AND gi.latest_created_at = gih.created_at " +
    "INNER JOIN group_types gt ON gt.id = g.type_id " +
    "WHERE g.user_id = ? " +
    "ORDER BY inquiryCreatedAt DESC "
    )
    List<GroupFindAllByReaderIdInterface> findAllInquiriesByReaderId(Long reader);

}