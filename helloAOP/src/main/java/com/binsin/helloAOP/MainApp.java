package com.binsin.helloAOP;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("com/binsin/helloAOP/conf/animal.xml");
		
		PetOwner person = (PetOwner) context.getBean("id_petowner");
		person.play();
		
		context.close();
	}
}
