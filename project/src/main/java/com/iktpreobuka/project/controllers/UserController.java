package com.iktpreobuka.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iktpreobuka.project.entities.UserEntity;
import com.iktpreobuka.project.enums.Role;
import com.iktpreobuka.project.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/project/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// post mapping
	// T2 1.5
	@RequestMapping(method = RequestMethod.POST)
	public UserEntity add(@RequestBody ObjectNode objectNode) {

		UserEntity newUser = new UserEntity(objectNode.get("firstName").asText(), objectNode.get("lastName").asText(),
				objectNode.get("username").asText(), objectNode.get("password").asText(),
				objectNode.get("email").asText(), Role.fromString(objectNode.get("userRole").asText()));

		userRepository.save(newUser);

		return newUser;
	}

	// get mapping
	// T2 1.3
	@RequestMapping(method = RequestMethod.GET)
	public List<UserEntity> getAllUsers() {
		return (List<UserEntity>) userRepository.findAll();
	}

	// T2 1.4
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public UserEntity getById(@PathVariable Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	// T2 1.10
	@RequestMapping(method = RequestMethod.GET, value = "/by-username/{username}")
	public UserEntity getByUsername(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}

	// put mapping
	// T2 1.6
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public UserEntity changeUser(@PathVariable Integer id, @RequestBody ObjectNode objectNode) {

		UserEntity user = userRepository.findById(id).orElse(null);
		if (user == null)
			return null;

		String firstName = objectNode.get("firstName").asText();
		String lastName = objectNode.get("lastName").asText();
		String username = objectNode.get("username").asText();
		String password = objectNode.get("password").asText();
		String email = objectNode.get("email").asText();
		Role role = Role.fromString(objectNode.get("userRole").asText());

		if (firstName != null)
			user.setFirstName(firstName);
		if (lastName != null)
			user.setLastName(lastName);
		if (username != null)
			user.setUsername(username);
		if (password != null)
			user.setPassword(password);
		if (email != null)
			user.setEmail(email);
		if (role != null)
			user.setUserRole(role);

		userRepository.save(user);

		return user;
	}

	// T2 1.7
	@RequestMapping(method = RequestMethod.PUT, value = "/change/{id}/role")
	public UserEntity changeRole(@PathVariable Integer id, @RequestParam String role) {

		UserEntity user = userRepository.findById(id).orElse(null);
		if (user == null)
			return null;

		user.setUserRole(Role.fromString(role));
		userRepository.save(user);

		return user;
	}

	// T2 1.8
	@RequestMapping(method = RequestMethod.PUT, value = "/changePassword/{id}")
	public UserEntity changePassword(@PathVariable Integer id, @RequestParam String op, @RequestParam String np) {

		UserEntity user = userRepository.findById(id).orElse(null);

		if (user == null)
			return null;

		if (user.getPassword().equals(op))
			user.setPassword(np);

		userRepository.save(user);

		return user;
	}

	//delete mapping

	// T2 1.9
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public UserEntity delete(@PathVariable Integer id) {

		UserEntity user = userRepository.findById(id).orElse(null);
		if (user == null)
			return null;

		userRepository.delete(user);

		return user;
	}
}
