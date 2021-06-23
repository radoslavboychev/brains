package com.iktpreobuka.project.enums;

public enum Role {

	ROLE_CUSTOMER("customer"), ROLE_ADMIN("admin"), ROLE_SELLER("seller");

	private String role;

	private Role(String role) {
		this.role = role;
	}

	public static Role fromString(String in) {

		for (Role r : Role.values())
			if (r.role.equalsIgnoreCase(in))
				return r;

		return null;
	}

	@Override
	public String toString() {
		return role;
	}
}
