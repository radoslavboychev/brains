package com.iktpreobuka.project.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.OfferEntity;
import com.iktpreobuka.project.entities.OfferEntity.EOfferStatus;

/**
 * 
 * Zadatak 3.2
 *
 */
@RestController

public class OfferController {

	/**
	 * 
	 * Zadatak 3.3
	 */

	@RequestMapping("/project/offers")
	private List<OfferEntity> getDB() {
		List<OfferEntity> offers = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 5);

		OfferEntity o1 = new OfferEntity(1, "2 tickets for Killers concert", "Enjoy!!!", new Date(), cal.getTime(),
				100000.00, 6500.00, " ", 10, 0, EOfferStatus.WAIT_FOR_APPROVING);

		OfferEntity o2 = new OfferEntity(2, "VIVAX 24LE76T2", "Don't miss this fantastic offer!", new Date(),
				cal.getTime(), 200000.00, 16500.00, " ", 4, 0, EOfferStatus.WAIT_FOR_APPROVING);

		OfferEntity o3 = new OfferEntity(3, "Dinner for two in Aqua Doria", "Excellent offer", new Date(),
				cal.getTime(), 6000.00, 3500.00, " ", 4, 0, EOfferStatus.WAIT_FOR_APPROVING);

		offers.add(o1);
		offers.add(o2);
		offers.add(o3);

		return offers;

	}

	/**
	 * Zadatak 3 - 3.4
	 */
	@PostMapping("/project/offers")
	public OfferEntity createOffer(@RequestBody OfferEntity createdOffer) {
		System.out.println("Offer: " + createdOffer.getId() + " " + createdOffer.getOfferName() + " "
				+ createdOffer.getOfferDescription() + " " + createdOffer.getOfferCreated() + " "
				+ createdOffer.getOfferCreated() + " " + createdOffer.getOfferExpires() + " "
				+ createdOffer.getAvailableOffers() + " " + createdOffer.getBoughtOffers() + " "
				+ createdOffer.getOfferStatus());

		getDB().add(createdOffer);
		return createdOffer;
	}

	/**
	 * Zadatak 3 - 3.5
	 */
	@PutMapping("/project/offers/{id}")
	public OfferEntity ediOffer(@PathVariable int id, @RequestBody OfferEntity editedOffer) {

		for (OfferEntity offer : getDB()) {
			if (offer.getId() == editedOffer.getId()) {
				offer.setId(editedOffer.getId());
				offer.setOfferName(editedOffer.getOfferName());
				offer.setOfferDescription(editedOffer.getOfferDescription());
				offer.setOfferCreated(editedOffer.getOfferCreated());
				offer.setOfferExpires(editedOffer.getOfferExpires());
				offer.setAvailableOffers(editedOffer.getAvailableOffers());
				offer.setBoughtOffers(editedOffer.getBoughtOffers());
				// offer.setOfferStatus(editedOffer.getOfferStatus());

				return editedOffer;
			}
		}
		return null;
	}

	/**
	 * Zadatak 3 - 3.6
	 */
	@DeleteMapping("/project/offers/{id}")
	public OfferEntity deleteOffer(@PathVariable int id) {
		for (OfferEntity offer : getDB()) {

			if (offer.getId() == id) {
				getDB().remove(id);
				return offer;
			}
		}
		return null;
	}

	/**
	 * Zadatak 3 - 3.7
	 */
	@GetMapping("/project/offers/{id}")
	public OfferEntity getOfferByID(@PathVariable int id) {
		for (OfferEntity offer : getDB()) {
			if (offer.getId() == id) {
				return offer;
			}
		}
		return null;
	}

	/**
	 * Zadatak 3 - 3.8
	 */
	@PutMapping("/project/offers/changeOffer/{id}/status/{status}")
	public OfferEntity changeOfferStatus(@PathVariable int id, @PathVariable EOfferStatus status) {
		for (OfferEntity offer : getDB()) {
			if (offer.getId() == id) {

				offer.setOfferStatus(status);
				return offer;
			}
		}

		return null;

	}

	/**
	 * Zadatak 3 - 3.9
	 */
	
	//if there isnt any action price, we check by normal price
	@GetMapping("/project/offers/findByPrice/{lowerPrice}/and/{upperPrice}")
	public OfferEntity findByPrice(@PathVariable double lowerPrice, @PathVariable double upperPrice) {

		for (OfferEntity offer : getDB()) {
			//check action price first
			if (offer.getActionPrice() >= lowerPrice && offer.getActionPrice() <= upperPrice) {
				return offer;
				//if there's no action price
			} else if (offer.getActionPrice() == 0) {
				if (offer.getRegularPrice() >= lowerPrice && offer.getRegularPrice() <= upperPrice) {
					return offer;
				} else
					return null;
			}
		}
		

		return null;

	}
}
