package com.example.damo.application.controllers;

import com.example.damo.application.usecases.groups.GetGroupUsecase;
import com.example.damo.application.usecases.groups.dtos.GetGroupUsecaseDto;
import com.example.damo.domains.group.dtos.*;
import com.example.damo.domains.group.interfaces.GroupFindAllByReaderIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
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
    private final GetGroupUsecase getGroupUsecase;
    @GetMapping("/{group}/{user}")
    public GetGroupUsecaseDto getById(@PathVariable Long group, @PathVariable Long user) {
        return getGroupUsecase.getGroupWithIsInquirer(group, user);
    }
    @GetMapping("/{type}")
    public List<GroupFindAllByTypeIdInterface> getAllGroupsByTypeId(@PathVariable Integer type) {
        return groupReadService.findAll(type);
    }
    @PostMapping()
    public void create(@RequestBody GroupSaveDto groupSaveDto) {
        groupWriteService.create(groupSaveDto);
    }


    @GetMapping("/{reader}/inquiries")
    public List<GroupFindAllByReaderIdInterface> getAllInquiriesByReaderId(Long reader) {
        return groupReadService.findAllInquiriesByReaderId(reader);
    }
}
