package com.example.damo.domains.user.services;

import com.example.damo.domains.user.entities.User;
import com.example.damo.domains.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserWriteService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
