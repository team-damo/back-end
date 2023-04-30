package com.example.damo.domains.group.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "group_join_history")
public class GroupJoinHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Column(name = "message", columnDefinition = "TEXT", nullable = false, length = 100)
    private String message;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Builder
    public GroupJoinHistory(Long id, Long userId, Long groupId, String message, Integer status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = Objects.requireNonNull(userId);
        this.groupId = Objects.requireNonNull(groupId);
        this.message = Objects.requireNonNull(message);
        validateMaxLengthBy(message, MESSAGE_SAFE_MAX_LENGTH);
        this.status = status < 3 ? status : 3;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt;
    }
    private static final int MESSAGE_SAFE_MAX_LENGTH = 100;
    private void validateMaxLengthBy(String target, int maxLength) {
        Assert.isTrue(target.length() <= maxLength, "최대 길이를 초과했습니다.");
    }
}
