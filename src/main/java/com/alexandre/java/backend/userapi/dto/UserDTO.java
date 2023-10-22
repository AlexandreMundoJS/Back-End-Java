package com.alexandre.java.backend.userapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime createDate;
}
