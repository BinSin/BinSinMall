package com.binsin.mall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/binsin/conf/beans.xml");
		
		OfferDAO offerDAO = (OfferDAO)context.getBean("offerDAO");
		System.out.println("The record count is " + offerDAO.getRowCount());
		
		List<Offer> offerList = offerDAO.getOffers();
		
		for(Offer offer : offerList) {
			System.out.println(offer);
		}
		
		// insert
		Offer offer = new Offer();
		offer.setId(5);
		offer.setName("binsin");
		offer.setEmail("binsin@binsin.com");
		offer.setText("hello~~!!!");
		if(offerDAO.insert(offer)) {
			System.out.println("Object is inserted successfully");
		} else {
			System.out.println("Object insert failed");
		}
		
		// update
		offer = offerDAO.getOffer("binsin");
		offer.setName("binsinKing");
		if(offerDAO.update(offer)) {
			System.out.println("Object is updated successfully");
		} else {
			System.out.println("Object update failed");
		}
		System.out.println(offer);
			
		// delete
		offer = offerDAO.getOffer("binsinKing");
		if(offerDAO.delete(offer.getId())) {
			System.out.println("Object is deleted successfully");
		} else {
			System.out.println("Object delete failed");
		}
		
		context.close();
	}
}
