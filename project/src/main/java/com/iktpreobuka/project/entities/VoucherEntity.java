package com.iktpreobuka.project.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class VoucherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Column(nullable = false)
	protected Date expirationDate;

	@Column(nullable = false)
	protected boolean isUsed;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "offer")
	protected OfferEntity offer;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user")
	protected UserEntity user;

	@Version
	private Integer version;

	public VoucherEntity() {
	}

	public Integer getId() {
		return id;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public OfferEntity getOffer() {
		return offer;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
