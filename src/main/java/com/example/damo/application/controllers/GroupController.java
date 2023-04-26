package com.example.damo.application.controllers;

import com.example.damo.domains.group.dtos.GroupFindAllByTypeIdDto;
import com.example.damo.domains.group.dtos.GroupSaveDto;
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
    public List<GroupFindAllByTypeIdDto> findAll(@PathVariable Integer type) {
        return groupReadService.findAll(type);
    }
    @PostMapping()
    public void create(@RequestBody GroupSaveDto groupSaveDto) {
        groupWriteService.create(groupSaveDto);
    }
}
