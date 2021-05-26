package com.iktpreobuka.project.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.UserEntity;
import com.iktpreobuka.project.entities.UserEntity.EUserRole;

@RestController

public class UserController {

	/**
	 * Zadatak 1 - 1.3
	 */
	@RequestMapping("/project/users")
	protected List<UserEntity> getDB() {
		List<UserEntity> users = new ArrayList<>();

		UserEntity u1 = new UserEntity(1, "Vladimir", "Dimitrieski", "dimitrieski@uns.ac.rs", "vladimir", "vladimir",
				EUserRole.ROLE_CUSTOMER);

		UserEntity u2 = new UserEntity(2, "Milan", "Celikovic", "milancel@uns.ac.rs", "milan", "milan",
				EUserRole.ROLE_CUSTOMER);

		UserEntity u3 = new UserEntity(3, "Nebojsa", "Horvat", "horva.n@uncs.ac.rs", "nebojsa", "nebojsa",
				EUserRole.ROLE_CUSTOMER);

		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;

	}

	/**
	 * Zadatak 1 - 1.4
	 */
	@RequestMapping("/project/users/{id}")
	public UserEntity getById(@PathVariable String id) {
		for (UserEntity user : getDB()) {
			if (user.getId() == Integer.parseInt(id))
				return user;
			else
				return null;
		}
		return null;
	}

	/**
	 * Zadatak 1 - 1.5
	 */
	@PostMapping("/project/users")
	public UserEntity createUser(@RequestBody UserEntity createdUser) {

		System.out.println("User: " + createdUser.getId() + " " + createdUser.getFirst_name() + " "
				+ createdUser.getLast_name() + " " + createdUser.getUsername() + " " + createdUser.getPassword() + " "
				+ createdUser.getUserRole());

		// set the role as customer, regardless of what the role has been set in the
		// request
		// TODO - make this better!?
		createdUser.setUserRole(EUserRole.ROLE_CUSTOMER);

		getDB().add(createdUser);

		// returns the user
		return createdUser;
	}

	/**
	 * Zadatak 1 - 1.6
	 */
	
	//TODO check if this is correct
	@PutMapping("/project/users/{id}")
	public UserEntity editUser(@PathVariable int id, @RequestBody UserEntity editedUser) {
		//changes the ID of the guy only
		UserEntity newUser = new UserEntity(id, "PutTester", "Surname", "email", "uName123", "pWord123", EUserRole.ROLE_CUSTOMER);
		for (UserEntity user : getDB()) {
			if (user.getId() == newUser.getId()) {
				user.setFirst_name(newUser.getFirst_name());
				user.setLast_name(newUser.getLast_name());
				user.setEmail(newUser.getEmail());
				return newUser;
			}
			
		}
		return null;
	}
}
