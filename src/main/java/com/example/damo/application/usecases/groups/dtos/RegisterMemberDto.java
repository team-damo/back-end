package com.example.damo.application.usecases.groups.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterMemberDto {
    private Long joinId;
    private Long groupId;
    private Long userId;
}
