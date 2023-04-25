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
@Table(name = "group_members")
public class GroupMember {
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
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @Builder
    public GroupMember(Long id, Long userId, Long groupId, LocalDateTime createdAt, LocalDateTime deletedAt) {
        this.id = id;
        this.userId = Objects.requireNonNull(userId);
        this.groupId = Objects.requireNonNull(groupId);
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.deletedAt = deletedAt;
    }
}
