package com.iktpreobuka.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public UserEntity getById(@PathVariable String id)
	{
		for (UserEntity user : getDB()) {
			if(user.getId() == Integer.parseInt(id))
				return user;
		}
		return null;
	}

}
