package com.example.damo.domains.group.services;


import com.example.damo.domains.group.repositories.GroupHitHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupHitHistoryReadService {
    private final GroupHitHistoryRepository groupHitHistoryRepository;
}
