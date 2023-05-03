package com.example.damo.domains.group.interfaces;

import java.time.LocalDateTime;

public interface GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface {
    Long getId();
    Long getUserId();
    Long getGroupId();
    String getMessage();
    Integer getStatus();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
