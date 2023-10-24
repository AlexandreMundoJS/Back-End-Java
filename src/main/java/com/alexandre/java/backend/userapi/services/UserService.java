package com.alexandre.java.backend.userapi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
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

    public UserDTO save(UserDTO userDTO) {
        userDTO.setCreateDate(LocalDateTime.now());
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }

    public void delete(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> users = userRepository.queryByNameLike(name);
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public UserDTO editUser(long userId, UserDTO userDTO){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));
        if (user.getEmail() != null && !user.getEmail().equals(userDTO.getEmail())) {
            user.setEmail(user.getEmail());
        } 
        if (user.getPhone() != null && !user.getPhone().equals(userDTO.getPhone())) {
            user.setPhone(user.getPhone());
        } 
        if (user.getAddress() != null && !user.getAddress().equals(userDTO.getAddress())) {
            user.setAddress(user.getAddress());
        } 

        user = userRepository.save(user);
        return UserDTO.convert(user);
    }

    // public Page<UserDTO> getAllPages(Pageable page) {
    //     Page<User> users = userRepository.findAll(page);
    //     return users.map(UserDTO::convert);
    // }
}