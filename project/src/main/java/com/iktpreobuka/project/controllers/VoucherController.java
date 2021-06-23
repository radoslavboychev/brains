package com.iktpreobuka.project.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iktpreobuka.project.entities.OfferEntity;
import com.iktpreobuka.project.entities.UserEntity;
import com.iktpreobuka.project.entities.VoucherEntity;
import com.iktpreobuka.project.enums.Role;
import com.iktpreobuka.project.repositories.OfferRepository;
import com.iktpreobuka.project.repositories.UserRepository;
import com.iktpreobuka.project.repositories.VoucherRepository;

@RestController
@RequestMapping("/api/v1/project/vouchers")
public class VoucherController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private VoucherRepository voucherRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OfferRepository offerRepository;

	// post mapping
	// T3 4.6
	@RequestMapping(method = RequestMethod.POST, value = "/{offerId}/buyer/{buyerId}")
	public VoucherEntity add(@PathVariable Integer offerId, @PathVariable Integer buyerId,
			@RequestBody ObjectNode objectNode) {

		OfferEntity offer = offerRepository.findById(offerId).orElse(null);
		UserEntity buyer = userRepository.findById(buyerId).orElse(null);

		if (offer == null || buyer == null || buyer.getUserRole() != Role.ROLE_CUSTOMER)
			return null;

		VoucherEntity newVoucher = new VoucherEntity();
		newVoucher.setExpirationDate(Date.valueOf(
				LocalDate.parse(objectNode.get("expDate").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
		newVoucher.setUsed(false);
		newVoucher.setOffer(offer);
		newVoucher.setUser(buyer);

		voucherRepository.save(newVoucher);

		return newVoucher;
	}

	// get mapping
	// T3 4.3
	@RequestMapping(method = RequestMethod.GET)
	public List<VoucherEntity> getAllVouchers() {
		return (List<VoucherEntity>) voucherRepository.findAll();
	}

	// T3 4.7
	@RequestMapping(method = RequestMethod.GET, value = "/findByBuyer/{buyerId}")
	public List<VoucherEntity> getAllVouchersByBuyer(@PathVariable Integer buyerId) {

		UserEntity buyer = userRepository.findById(buyerId).orElse(null);
		if (buyer == null)
			return null;

		List<VoucherEntity> vouchers = voucherRepository.findByUser(buyer);

		return vouchers;
	}

	// T3 4.8
	@RequestMapping(method = RequestMethod.GET, value = "/findByOffer/{offerId}")
	public List<VoucherEntity> getAllVouchersByOffer(@PathVariable Integer offerId) {

		OfferEntity offer = offerRepository.findById(offerId).orElse(null);
		if (offer == null)
			return null;

		List<VoucherEntity> vouchers = voucherRepository.findByOffer(offer);

		return vouchers;
	}

	// T3 4.9
	@RequestMapping(method = RequestMethod.GET, value = "/findNonExpiredVoucher")
	public List<VoucherEntity> getNonExpiredVouchers() {

		Date now = Date.valueOf(LocalDate.now());

		String hql = "select v from VoucherEntity v where v.expirationDate > :dateX";
		Query q = em.createQuery(hql);
		q.setParameter("dateX", now);

		List<VoucherEntity> vouchers = q.getResultList();

		return vouchers;
	}

	// put mapping
	// T3 4.6
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/{offerId}/buyer/{buyerId}")
	public VoucherEntity changeVoucher(@PathVariable Integer id, @PathVariable Integer offerId,
			@PathVariable Integer buyerId, @RequestBody ObjectNode objectNode) {

		VoucherEntity voucher = voucherRepository.findById(id).orElse(null);
		OfferEntity offer = offerRepository.findById(offerId).orElse(null);
		UserEntity buyer = userRepository.findById(buyerId).orElse(null);

		if (voucher == null || offer == null || buyer == null || buyer.getUserRole() != Role.ROLE_CUSTOMER)
			return null;

		voucher.setExpirationDate(Date.valueOf(
				LocalDate.parse(objectNode.get("expDate").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
		voucher.setUser(buyer);
		voucher.setOffer(offer);

		voucherRepository.save(voucher);

		return voucher;
	}

	//delete mapping
	// T3 4.6
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public VoucherEntity delete(@PathVariable Integer id) {

		VoucherEntity voucher = voucherRepository.findById(id).orElse(null);
		if (voucher == null)
			return null;

		voucherRepository.delete(voucher);

		return voucher;
	}
}
