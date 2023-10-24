package com.alexandre.java.backend.userapi.entitites;

import java.time.LocalDateTime;

import com.alexandre.java.backend.userapi.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    
    @Column(name="create_date")
    private LocalDateTime createDate;

    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCreateDate(userDTO.getCreateDate());
        return user;
    }
}
