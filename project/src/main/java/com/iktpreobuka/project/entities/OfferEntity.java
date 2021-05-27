package com.iktpreobuka.project.entities;

import java.util.Date;

/**
 * 
 * Zadatak 3 - 3.1
 *
 */

public class OfferEntity {

	// attributes

	private int id;
	private String offerName;
	private String offerDescription;
	private Date offerCreated;
	private Date offerExpires;
	private double regularPrice;
	private double actionPrice;
	private String imagePath;
	private int availableOffers;
	private int boughtOffers;

	public enum EOfferStatus {
		WAIT_FOR_APPROVING, APPROVED, DECLINED, EXPIRED
	}

	private EOfferStatus offerStatus;

	// constructor
	/**
	 * @param id
	 * @param offerName
	 * @param offerDescription
	 * @param offerCreated
	 * @param offerExpires
	 * @param regularPrice
	 * @param actionPrice
	 * @param imagePath
	 * @param availableOffers
	 * @param boughtOffers
	 * @param offerStatus
	 */
	public OfferEntity(int id, String offerName, String offerDescription, Date offerCreated, Date offerExpires,
			double regularPrice, double actionPrice, String imagePath, int availableOffers, int boughtOffers,
			EOfferStatus offerStatus) {
		super();
		this.id = id;
		this.offerName = offerName;
		this.offerDescription = offerDescription;
		this.offerCreated = offerCreated;
		this.offerExpires = offerExpires;
		this.regularPrice = regularPrice;
		this.actionPrice = actionPrice;
		this.imagePath = imagePath;
		this.availableOffers = availableOffers;
		this.boughtOffers = boughtOffers;
		this.offerStatus = offerStatus;
		if (boughtOffers > availableOffers) {
			System.out.println("Error. Bought offers are more than available offers!");
		}
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public Date getOfferCreated() {
		return offerCreated;
	}

	public void setOfferCreated(Date offerCreated) {
		this.offerCreated = offerCreated;
	}

	public Date getOfferExpires() {
		return offerExpires;
	}

	public void setOfferExpires(Date offerExpires) {
		this.offerExpires = offerExpires;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(float regularPrice) {
		this.regularPrice = regularPrice;
	}

	public double getActionPrice() {
		return actionPrice;
	}

	public void setActionPrice(float actionPrice) {
		this.actionPrice = actionPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getAvailableOffers() {
		return availableOffers;
	}

	public void setAvailableOffers(int availableOffers) {
		this.availableOffers = availableOffers;
	}

	public int getBoughtOffers() {
		return boughtOffers;
	}

	public void setBoughtOffers(int boughtOffers) {
		this.boughtOffers = boughtOffers;
	}

	public EOfferStatus getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(EOfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}

}
