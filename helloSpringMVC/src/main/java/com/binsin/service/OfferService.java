package com.binsin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binsin.dao.OfferDAO;
import com.binsin.model.Offer;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;
	
	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

}
