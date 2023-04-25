package com.example.damo.application.controllers;

import com.example.damo.domains.group.dtos.GroupDto;
import com.example.damo.domains.group.services.GroupReadService;
import com.example.damo.domains.group.services.GroupWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupWriteService groupWriteService;
    private final GroupReadService groupReadService;

    @GetMapping("/{type}")
    public List<GroupDto> findAll(@PathVariable Integer type) {
        return groupReadService.findAll(type);
    }
    @PostMapping()
    public void create(@RequestBody GroupDto groupDto) {
        groupWriteService.create(groupDto);
    }
}
