package com.example.damo.domains.group.repositories;

import com.example.damo.domains.group.entities.GroupInquiryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface GroupInquiryHistoryRepository extends JpaRepository<GroupInquiryHistory, Long> {
}