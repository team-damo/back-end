package com.example.damo.domains.group.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "group_hit_history")
public class GroupHitHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public GroupHitHistory(Long id, Long userId, Long groupId, LocalDateTime createdAt) {
        this.id = id;
        this.userId =Objects.requireNonNull(userId);
        this.groupId = Objects.requireNonNull(groupId);
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }
}
