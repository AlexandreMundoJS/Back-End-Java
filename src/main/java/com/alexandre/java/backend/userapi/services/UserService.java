package com.alexandre.java.backend.userapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alexandre.java.backend.userapi.dto.UserDTO;
import com.alexandre.java.backend.userapi.entitites.User;
import com.alexandre.java.backend.userapi.interfaces.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDTO.convert(user);
    }
}