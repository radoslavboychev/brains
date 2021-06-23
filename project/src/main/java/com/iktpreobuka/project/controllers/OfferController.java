package com.iktpreobuka.project.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iktpreobuka.project.entities.CategoryEntity;
import com.iktpreobuka.project.entities.OfferEntity;
import com.iktpreobuka.project.entities.UserEntity;
import com.iktpreobuka.project.enums.OfferType;
import com.iktpreobuka.project.enums.Role;
import com.iktpreobuka.project.repositories.CategoryRepository;
import com.iktpreobuka.project.repositories.OfferRepository;
import com.iktpreobuka.project.repositories.UserRepository;
import com.iktpreobuka.project.utils.DateConverter;

@RestController
@RequestMapping("/api/v1/project/offers")
public class OfferController {

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	//post mapping
	// T3 2.3
	@RequestMapping(method = RequestMethod.POST, value = "/{categoryId}/seller/{sellerId}")
	public OfferEntity add(@PathVariable Integer categoryId, @PathVariable Integer sellerId,
			@RequestBody ObjectNode objectNode) {

		OfferEntity newOffer = new OfferEntity(objectNode.get("name").asText(), objectNode.get("description").asText(),
				Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(10)),
				Double.parseDouble(objectNode.get("regPrice").asText().trim()),
				Double.parseDouble(objectNode.get("actPrice").asText().trim()), objectNode.get("imgPath").asText(),
				Integer.parseInt(objectNode.get("numAvailable").asText().trim()),
				Integer.parseInt(objectNode.get("numBought").asText().trim()),
				OfferType.fromString(objectNode.get("offerType").asText()));

		UserEntity user = userRepository.findById(sellerId).orElse(null);
		CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);

		if (user == null || user.getUserRole() != Role.ROLE_SELLER || category == null)
			return null;

		newOffer.setUser(user);
		newOffer.setCategory(category);

		offerRepository.save(newOffer);

		return newOffer;
	}

	//get mapping
	// T2 3.3
	@RequestMapping(method = RequestMethod.GET)
	public List<OfferEntity> getAllOffers() {
		return (List<OfferEntity>) offerRepository.findAll();
	}

	// T2 3.7
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public OfferEntity getById(@PathVariable Integer id) {

		return offerRepository.findById(id).orElse(null);
	}

	// T2 3.9
	@RequestMapping(method = RequestMethod.GET, value = "/findByPrice/{lowerPrice}/and/{upperPrice}")
	public List<OfferEntity> getByRange(@PathVariable Integer lowerPrice, @PathVariable Integer upperPrice) {

		List<OfferEntity> offers = (List<OfferEntity>) offerRepository.findAll();

		return offers.stream().filter(o -> lowerPrice <= o.getActPrice() && o.getActPrice() < upperPrice)
				.collect(Collectors.toList());
	}

	//put mapping
	// T2 3.5 - Edited in T3
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/{categoryId}/seller/{sellerId}")
	public OfferEntity changeOffer(@PathVariable Integer id, @PathVariable Integer categoryId,
			@PathVariable Integer sellerId, @RequestBody ObjectNode objectNode) {

		OfferEntity offer = offerRepository.findById(id).orElse(null);
		CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);
		UserEntity seller = userRepository.findById(sellerId).orElse(null);

		if (offer == null || category == null || seller == null || seller.getUserRole() != Role.ROLE_SELLER)
			return null;

		String name = objectNode.get("name").asText();
		String desc = objectNode.get("description").asText();
		Date created = Date.valueOf(objectNode.get("created").asText());
		Date expires = Date.valueOf(objectNode.get("expires").asText());
		double regPrice = Double.parseDouble(objectNode.get("regPrice").asText().trim());
		double actPrice = Double.parseDouble(objectNode.get("actPrice").asText().trim());
		String imgPath = objectNode.get("imgPath").asText();
		int numAvailable = Integer.parseInt(objectNode.get("numAvailable").asText().trim());
		int numBought = Integer.parseInt(objectNode.get("numBought").asText().trim());
		OfferType type = OfferType.fromString(objectNode.get("offerType").asText().trim());

		if (name != null)
			offer.setName(name);
		if (desc != null)
			offer.setDesc(desc);
		if (created != null)
			offer.setCreated(created);
		if (expires != null)
			offer.setExpires(expires);
		offer.setRegPrice(regPrice);
		offer.setActPrice(actPrice);
		if (imgPath != null)
			offer.setImgPath(imgPath);
		offer.setNumAvailable(numAvailable);
		offer.setNumBought(numBought);
		if (type != null)
			offer.setType(type);

		offer.setCategory(category);
		offer.setUser(seller);

		offerRepository.save(offer);

		return offer;
	}

	// T2 3.8
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/type")
	public OfferEntity changeType(@PathVariable Integer id, @RequestParam String type) {

		OfferEntity offer = offerRepository.findById(id).orElse(null);
		if (offer == null)
			return null;

		offer.setType(OfferType.fromString(type));
		offerRepository.save(offer);

		return offer;
	}

	// T3 2.4
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/category/{categoryId}")
	public OfferEntity changeCategory(@PathVariable Integer id, @PathVariable Integer categoryId) {

		OfferEntity offer = offerRepository.findById(id).orElse(null);
		if (offer == null)
			return null;

		CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null)
			return offer;

		offer.setCategory(category);
		offerRepository.save(offer);

		return offer;
	}

	//delete mapping
	// T2 3.6
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public OfferEntity delete(@PathVariable Integer id) {

		OfferEntity offer = offerRepository.findById(id).orElse(null);
		if (offer == null)
			return null;

		offerRepository.delete(offer);

		return offer;
	}
}
