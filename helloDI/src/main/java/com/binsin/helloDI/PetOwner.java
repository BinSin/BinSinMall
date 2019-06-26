package com.binsin.helloDI;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetOwner {
	
	private final AnimalType animal;
	
	public void play() {
		animal.sound();
	}
	
}
