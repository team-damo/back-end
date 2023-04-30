package com.example.damo.application.usecases.groups.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetGroupUsecaseDto {
    private Long id;
    private Long userId;
    private String type;
    private String name;
    private String introduction;
    private Integer maxUser;
    private Boolean isDone;
    private String deadlineAt;
    private String createdAt;
    private String deletedAt;
    private Long hit;
    private Boolean isInquirer;
}
