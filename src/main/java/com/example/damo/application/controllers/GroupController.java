package com.example.damo.application.controllers;

import com.example.damo.domains.group.dtos.GroupDto;
import com.example.damo.domains.group.services.GroupWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupWriteService groupWriteService;

    @PostMapping("")
    public void create(@RequestBody GroupDto groupDto) {
        groupWriteService.create(groupDto);
    }
}
