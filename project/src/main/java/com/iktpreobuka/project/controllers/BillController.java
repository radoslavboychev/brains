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
import com.iktpreobuka.project.entities.BillEntity;
import com.iktpreobuka.project.entities.CategoryEntity;
import com.iktpreobuka.project.entities.OfferEntity;
import com.iktpreobuka.project.entities.UserEntity;
import com.iktpreobuka.project.repositories.BillRepository;
import com.iktpreobuka.project.repositories.CategoryRepository;
import com.iktpreobuka.project.repositories.OfferRepository;
import com.iktpreobuka.project.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/project/bills")
public class BillController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	//post mapping
	// T3 3.6 - Edited T3 5.1
	@RequestMapping(method = RequestMethod.POST, value = "/{offerId}/buyer/{buyerId}")
	public BillEntity add(@PathVariable Integer offerId, @PathVariable Integer buyerId,
			@RequestBody ObjectNode objectNode) {

		OfferEntity offer = offerRepository.findById(offerId).orElse(null);
		UserEntity user = userRepository.findById(buyerId).orElse(null);

		if (offer == null || user == null)
			return null;

		offer.setNumAvailable(offer.getNumAvailable() - 1);
		offer.setNumBought(offer.getNumBought() + 1);

		offerRepository.save(offer);

		BillEntity bill = new BillEntity();
		bill.setBillCreated(Date.valueOf(LocalDate.now()));
		bill.setPaymentCanceled(objectNode.get("canceled").textValue().equalsIgnoreCase("yes") ? true : false);
		bill.setPaymentMade(objectNode.get("made").textValue().equalsIgnoreCase("yes") ? true : false);

		bill.setUser(user);
		bill.setOffer(offer);

		billRepository.save(bill);

		return bill;
	}

	//get mapping
	// T3 3.3
	@RequestMapping(method = RequestMethod.GET)
	public List<BillEntity> getAllBills() {
		return (List<BillEntity>) billRepository.findAll();
	}

	// T3 3.7
	@RequestMapping(method = RequestMethod.GET, value = "/findByBuyer/{buyerId}")
	public List<BillEntity> getAllBillsByBuyer(@PathVariable Integer buyerId) {

		UserEntity buyer = userRepository.findById(buyerId).orElse(null);
		if (buyer == null)
			return null;

		List<BillEntity> bills = billRepository.findByUser(buyer);

		return bills;
	}

	// T3 3.8
	@RequestMapping(method = RequestMethod.GET, value = "/findByCategory/{categoryId}")
	public List<BillEntity> getAllBillsByCategory(@PathVariable Integer categoryId) {

		CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);
		if (category == null)
			return null;

		String hql = "select b from BillEntity b where b.offer.category = :catX";

		Query query = em.createQuery(hql);
		query.setParameter("catX", category);

		List<BillEntity> bills = query.getResultList();

		return bills;
	}

	// T3 3.9
	@RequestMapping(method = RequestMethod.GET, value = "/findByDate/{startDate}/and/{endDate}")
	public List<BillEntity> getAllBillsBetweenDates(@PathVariable String startDate, @PathVariable String endDate) {

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate start = LocalDate.parse(startDate, dateFormat);
		LocalDate end = LocalDate.parse(endDate, dateFormat);

		Date s = Date.valueOf(start);
		Date e = Date.valueOf(end);

		String hql = "select b from BillEntity b where b.billCreated between :startX and :endX";
		Query q = em.createQuery(hql);
		q.setParameter("startX", s);
		q.setParameter("endX", e);

		List<BillEntity> bills = q.getResultList();

		return bills;
	}

	//putmapping
	// T3 3.6 edited T3 5.2
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public BillEntity changeBill(@PathVariable Integer id, @RequestBody ObjectNode objectNode) {

		BillEntity bill = billRepository.findById(id).orElse(null);
		if (bill == null)
			return null;

		boolean paymentCanceled = objectNode.get("canceled").textValue().equalsIgnoreCase("yes") ? true : false;
		boolean paymentMade = objectNode.get("made").textValue().equalsIgnoreCase("yes") ? true : false;

		if (paymentCanceled) {

			bill.getOffer().setNumAvailable(bill.getOffer().getNumAvailable() + 1);
			bill.getOffer().setNumBought(bill.getOffer().getNumBought() - 1);

			offerRepository.save(bill.getOffer());
		}

		bill.setPaymentCanceled(paymentCanceled);
		bill.setPaymentMade(paymentMade);

		billRepository.save(bill);

		return bill;
	}

	//delete mapping
	// T3 3.6
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public BillEntity delete(@PathVariable Integer id) {

		BillEntity bill = billRepository.findById(id).orElse(null);
		if (bill == null)
			return null;

		billRepository.delete(bill);

		return bill;
	}
}
