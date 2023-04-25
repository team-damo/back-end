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
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "type_id", nullable = false)
    private Integer typeId;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "introduction", length = 200, columnDefinition = "TEXT", nullable = false)
    private String introduction;
    @Column(name = "max_user", nullable = false)
    private Integer maxUser;
    @Column(name = "is_done", nullable = false)
    private Boolean isDone;
    @Column(name = "deadline_at", nullable = true)
    private LocalDateTime deadlineAt;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @Builder
    public Group(Long id, Long userId, Integer typeId, String name, String introduction, Integer maxUser, Boolean isDone, LocalDateTime deadlineAt, LocalDateTime createdAt, LocalDateTime deletedAt) {
        this.id = id;
        this.userId = Objects.requireNonNull(userId);
        this.typeId = Objects.requireNonNull(typeId);
        this.name = Objects.requireNonNull(name);
        this.introduction = Objects.requireNonNull(introduction);
        validateMaxLengthBy(name, NAME_SAFE_MAX_LENGTH);
        validateMaxLengthBy(introduction, INTRODUCTION_SAFE_MAX_LENGTH);
        this.maxUser = maxUser == null ? MAX_USER : maxUser;
        this.isDone = Objects.requireNonNull(isDone);
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.deadlineAt = deadlineAt;
        this.deletedAt = deletedAt;
    }

    private static final int MAX_USER = 10;
    private static final int NAME_SAFE_MAX_LENGTH = 20;
    private static final int INTRODUCTION_SAFE_MAX_LENGTH = 200;

    private void validateMaxLengthBy(String target, int maxLength) {
        Assert.isTrue(target.length() <= maxLength, "최대 길이를 초과했습니다.");
    }
}
