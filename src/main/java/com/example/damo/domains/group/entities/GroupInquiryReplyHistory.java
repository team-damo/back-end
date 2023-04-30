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
@Table(name = "group_inquiry_reply_history")
public class GroupInquiryReplyHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // TODO: User Entity 생성되면 연동
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "inquirer_id", nullable = false)
    private Long inquirerId;

    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private Group group;
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Column(name = "contents", columnDefinition = "TEXT", nullable = false, length = 300)
    private String contents;
    @Column(name = "is_checked", nullable = false)
    private Boolean isChecked;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "checked_at")
    private LocalDateTime checkedAt;

    @Builder
    public GroupInquiryReplyHistory(Long id, Long userId, Long inquirerId, Group group, Long groupId, String contents, Boolean isChecked, LocalDateTime createdAt, LocalDateTime checkedAt) {
        this.id = id;
        this.userId = Objects.requireNonNull(userId);
        this.inquirerId = Objects.requireNonNull(inquirerId);
        this.group = group;
        this.groupId = Objects.requireNonNull(groupId);
        this.contents = Objects.requireNonNull(contents);
        validateMaxLengthBy(contents, CONTENTS_SAFE_MAX_LENGTH);
        this.isChecked = isChecked != null && isChecked;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.checkedAt = checkedAt;
    }
    private static final int CONTENTS_SAFE_MAX_LENGTH = 300;
    private void validateMaxLengthBy(String target, int maxLength) {
        Assert.isTrue(target.length() <= maxLength, "최대 길이를 초과했습니다.");
    }
}