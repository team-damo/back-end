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
    private LocalDateTime deadlineAt;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private Boolean isInquirer;
}
