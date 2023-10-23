package com.alexandre.java.backend.userapi.dto;

import java.time.LocalDateTime;

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
}
