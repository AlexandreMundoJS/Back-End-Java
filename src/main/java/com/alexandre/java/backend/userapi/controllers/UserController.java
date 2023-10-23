package com.alexandre.java.backend.userapi.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.java.backend.userapi.dto.UserDTO;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	public static List<UserDTO> users = new ArrayList<UserDTO>();

	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setName("Alexandre");
		userDTO.setCpf("00000000000");
		userDTO.setAddress("Rua, Bairro, Cidade, Estado, Pais, CEP");
		userDTO.setEmail("meuEmail@email.com");
		userDTO.setPhone("(99) 99999-9999");
		userDTO.setCreateDate(LocalDateTime.now());

		UserDTO userDTO2 = new UserDTO();
		userDTO2.setName("Alexandre2");
		userDTO2.setCpf("00000000001");
		userDTO2.setAddress("Rua, Bairro, Cidade, Estado, Pais, CEP");
		userDTO2.setEmail("meuEmail@email.com");
		userDTO2.setPhone("(99) 99999-9999");
		userDTO2.setCreateDate(LocalDateTime.now());

		UserDTO userDTO3 = new UserDTO();
		userDTO3.setName("Alexandre3");
		userDTO3.setCpf("00000000002");
		userDTO3.setAddress("Rua, Bairro, Cidade, Estado, Pais, CEP");
		userDTO3.setEmail("meuEmail@email.com");
		userDTO3.setPhone("(99) 99999-9999");
		userDTO3.setCreateDate(LocalDateTime.now());

		users.add(userDTO);
		users.add(userDTO2);
		users.add(userDTO3);
	}

	@GetMapping
	public List<UserDTO> getUsers() {
		return users;
	}

	@GetMapping("/{cpf}")
	public UserDTO getUserByCpf(@PathVariable String cpf) {
		return users.stream()
				.filter(userDTO -> userDTO.getCpf().equals(cpf))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("User not found."));
	}

	@PostMapping
	public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
		userDTO.setCreateDate(LocalDateTime.now());
		users.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/{cpf}")
	public boolean deleteUser(@PathVariable String cpf) {
		return users.removeIf(userDto -> userDto.getCpf().equals(cpf));
	}
}