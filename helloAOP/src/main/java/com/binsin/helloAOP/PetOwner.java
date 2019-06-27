package com.binsin.helloAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {
	
	// 타입에 따른 bean이 자동으로 주입된다.
	@Autowired
	@Qualifier(value="qf_dog")
	private AnimalType animal;
	
	public void play() {
		animal.sound();
	}
	
}
