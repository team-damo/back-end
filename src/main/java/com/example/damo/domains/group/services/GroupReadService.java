package com.example.damo.domains.group.services;

import com.example.damo.domains.group.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupReadService {
    private final GroupRepository groupRepository;
}
