package com.iktpreobuka.project.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class BillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Column(nullable = false)
	protected Boolean paymentMade;

	@Column(nullable = false)
	protected Boolean paymentCanceled;

	@Column(nullable = false)
	protected Date billCreated;

	@Version
	private Integer version;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "offer")
	protected OfferEntity offer;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user")
	protected UserEntity user;

	public BillEntity() {
	}

	public Integer getId() {
		return id;
	}

	public Boolean getPaymentMade() {
		return paymentMade;
	}

	public Boolean getPaymentCanceled() {
		return paymentCanceled;
	}

	public Date getBillCreated() {
		return billCreated;
	}

	public Integer getVersion() {
		return version;
	}

	public OfferEntity getOffer() {
		return offer;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setPaymentMade(Boolean paymentMade) {
		this.paymentMade = paymentMade;
	}

	public void setPaymentCanceled(Boolean paymentCanceled) {
		this.paymentCanceled = paymentCanceled;
	}

	public void setBillCreated(Date billCreated) {
		this.billCreated = billCreated;
	}

	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
