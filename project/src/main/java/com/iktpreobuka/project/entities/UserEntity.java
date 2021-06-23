package com.iktpreobuka.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iktpreobuka.project.enums.Role;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Column(nullable = false)
	protected String firstName;

	@Column(nullable = false)
	protected String lastName;

	@Column(nullable = false)
	protected String username;

	@Column(nullable = false)
	protected String password;

	@Column(nullable = false)
	protected String email;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	protected Role userRole;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<OfferEntity> offers = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<BillEntity> bills = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<VoucherEntity> vouchers = new ArrayList<>();

	@Version
	private Integer version;

	public UserEntity() {
	}

	public UserEntity(String firstName, String lastName, String username, String password, String email,
			Role userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Role getUserRole() {
		return userRole;
	}

	public List<OfferEntity> getOffers() {
		return offers;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public List<VoucherEntity> getVouchers() {
		return vouchers;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public void setOffers(List<OfferEntity> offers) {
		this.offers = offers;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public void setVouchers(List<VoucherEntity> vouchers) {
		this.vouchers = vouchers;
	}

	@Override
	public String toString() {
		return String.format("[%05d] %s %s", id, firstName, lastName);
	}
}
