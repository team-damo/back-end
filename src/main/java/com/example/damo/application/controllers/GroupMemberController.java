package com.example.damo.application.controllers;

import com.example.damo.application.usecases.groups.GroupUseCase;
import com.example.damo.application.usecases.groups.dtos.RegisterMemberDto;
import com.example.damo.domains.group_member.services.GroupMemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/group-members")
public class GroupMemberController {
    private final GroupUseCase groupUseCase;

    @PostMapping()
    public void registerMember(@RequestBody RegisterMemberDto registerMemberDto) {
        groupUseCase.registerMember(registerMemberDto);
    }
}
