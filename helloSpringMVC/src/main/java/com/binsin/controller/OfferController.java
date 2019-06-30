package com.binsin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binsin.model.Offer;
import com.binsin.service.OfferService;

@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerSerivce;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerSerivce.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
}
