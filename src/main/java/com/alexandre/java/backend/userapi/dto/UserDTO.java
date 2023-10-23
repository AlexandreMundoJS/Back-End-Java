package com.alexandre.java.backend.userapi.dto;

import java.time.LocalDateTime;

import com.alexandre.java.backend.userapi.entitites.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "CPF is mandatory")
    private String cpf;
    private String address;
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String phone;
    private LocalDateTime createDate;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setCpf(user.getCpf());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setCreateDate(user.getCreateDate());
        return userDTO;
    }
}
