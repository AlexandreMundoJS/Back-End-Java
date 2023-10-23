package com.alexandre.java.backend.userapi.controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.java.backend.userapi.dto.UserDTO;
import com.alexandre.java.backend.userapi.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserDTO> getUsers() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public UserDTO getUserByCpf(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/{cpf}/cpf")
	public UserDTO getUserByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id) throws UserPrincipalNotFoundException {
		userService.delete(id);
	}

	@GetMapping("/search")
	public List<UserDTO> queryByName(@RequestParam(name="name", required = true) String name) {
		return userService.queryByName(name);
	}

}