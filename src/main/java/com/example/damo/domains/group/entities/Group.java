package com.example.damo.domains.group.entities;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Group {
    private final Long id;
    private final Long userId;
    private final Byte typeId;
    private final String name;
    private final String introduction;
    private final Integer maxUser;
    private final Boolean isDone;
    private final LocalDateTime deadlineAt;
    private final LocalDateTime createdAt;
    private final LocalDateTime deletedAt;

    @Builder
    public Group(Long id, Long userId, Byte typeId, String name, String introduction, Integer maxUser, Boolean isDone, LocalDateTime deadlineAt, LocalDateTime createdAt, LocalDateTime deletedAt) {
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
