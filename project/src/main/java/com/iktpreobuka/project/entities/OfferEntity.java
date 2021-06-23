package com.iktpreobuka.project.entities;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iktpreobuka.project.enums.OfferType;

@Entity
public class OfferEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	@Column(nullable = false)
	protected String name;

	@Column(nullable = false)
	protected String description;

	@Column(nullable = false)
	protected Date created;

	@Column(nullable = false)
	protected Date expires;

	@Column(nullable = false)
	protected Double regPrice;

	@Column(nullable = false)
	protected Double actPrice;

	@Column(nullable = false)
	protected String imgPath;

	@Column(nullable = false)
	protected Integer numAvailable;

	@Column(nullable = false)
	protected Integer numBought;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	protected OfferType type;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category")
	private CategoryEntity category;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user")
	private UserEntity user;

	@JsonIgnore
	@OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<BillEntity> bills = new ArrayList<BillEntity>();

	@JsonIgnore
	@OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<VoucherEntity> vouchers = new ArrayList<VoucherEntity>();

	@Version
	private Integer version;

	public OfferEntity() {
	}

	public OfferEntity(String name, String desc, Date created, Date expires, double regPrice, double actPrice,
			String imgPath, int numAvailable, int numBought, OfferType type) {
		this.name = name;
		this.description = desc;
		this.created = created;
		this.expires = expires;
		this.regPrice = regPrice;
		this.actPrice = actPrice;
		this.imgPath = imgPath;
		this.numAvailable = numAvailable;
		this.numBought = numBought;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return description;
	}

	public Date getCreated() {
		return created;
	}

	public Date getExpires() {
		return expires;
	}

	public Double getRegPrice() {
		return regPrice;
	}

	public Double getActPrice() {
		return actPrice;
	}

	public String getImgPath() {
		return imgPath;
	}

	public Integer getNumAvailable() {
		return numAvailable;
	}

	public Integer getNumBought() {
		return numBought;
	}

	public OfferType getType() {
		return type;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public UserEntity getUser() {
		return user;
	}

	public String getDescription() {
		return description;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	public void setRegPrice(Double regPrice) {
		this.regPrice = regPrice;
	}

	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public void setNumAvailable(Integer numAvailable) {
		this.numAvailable = numAvailable;
	}

	public void setNumBought(Integer numBought) {
		this.numBought = numBought;
	}

	public void setType(OfferType type) {
		this.type = type;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public void setVouchers(List<VoucherEntity> vouchers) {
		this.vouchers = vouchers;
	}
}
