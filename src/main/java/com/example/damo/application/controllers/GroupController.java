package com.example.damo.application.controllers;

import com.example.damo.application.usecases.groups.GroupUseCase;
import com.example.damo.application.usecases.groups.dtos.GetGroupUseCaseDto;
import com.example.damo.domains.group.dtos.*;
import com.example.damo.domains.group.interfaces.GroupFindAllByReaderIdInterface;
import com.example.damo.domains.group.interfaces.GroupFindAllByTypeIdInterface;
import com.example.damo.domains.group.interfaces.GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface;
import com.example.damo.domains.group.services.GroupJoinHistoryReadService;
import com.example.damo.domains.group.services.GroupJoinHistoryWriteService;
import com.example.damo.domains.group.services.GroupReadService;
import com.example.damo.domains.group.services.GroupWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupWriteService groupWriteService;
    private final GroupReadService groupReadService;
    private final GroupUseCase getGroupUseCase;
    private final GroupJoinHistoryWriteService groupJoinHistoryWriteService;
    private final GroupJoinHistoryReadService groupJoinHistoryReadService;
    @GetMapping("/{groupId}/{userId}")
    public GetGroupUseCaseDto getById(@PathVariable Long groupId, @PathVariable Long userId) {
        return getGroupUseCase.getGroupWithIsInquirer(groupId, userId);
    }
    @GetMapping("/{typeId}")
    public Page<GroupFindAllByTypeIdInterface> getAllGroupsByTypeId(@PathVariable Integer typeId, @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return groupReadService.findAll(typeId, pageable);
    }
    @PostMapping()
    public void create(@RequestBody GroupSaveDto groupSaveDto) {
        groupWriteService.create(groupSaveDto);
    }

    @GetMapping("/{readerId}/inquiries")
    public List<GroupFindAllByReaderIdInterface> getAllInquiriesByReaderId(Long readerId) {
        return groupReadService.findAllInquiriesByReaderId(readerId);
    }

    @GetMapping("/{groupId}/members/joins")
    public List<GroupJoinHistoryFindAllByGroupIdAndDefaultStatusInterface> getAllJoinMembersByGroupId(@PathVariable Long groupId) {
        return groupJoinHistoryReadService.getAllJoinMembersByGroupId(groupId);
    }
    @PostMapping("/members")
    public void registerJoinMember(@RequestBody GroupSaveJoinDto groupSaveJoinMemberDto) {
        groupJoinHistoryWriteService.registerJoinMember(groupSaveJoinMemberDto);
    }
}
