package com.example.damo.domains.group_member.interfaces;

import java.time.LocalDateTime;

public interface GroupMemberInterface {
    Long getId();
    Long getUserId();
    Long getGroupId();
    LocalDateTime getCreatedAt();
    LocalDateTime getDeletedAt();
}
