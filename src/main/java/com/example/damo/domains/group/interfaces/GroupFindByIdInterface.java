package com.example.damo.domains.group.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public interface GroupFindByIdInterface {
    Long getId();
    Long getUser_Id();
    String getType();
    String getName();
    String getIntroduction();
    Integer getMax_User();
    Boolean getIs_Done();
    String getDeadline_At();
    String getCreated_At();
    String getDeleted_At();
    Long getHit();
}
