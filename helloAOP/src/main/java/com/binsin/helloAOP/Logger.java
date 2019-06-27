package com.binsin.helloAOP;

public class Logger {

	public void beforeToSound() {
		System.out.println("before advice: about to sound() ");
	}
	
	public void afterToSound() {
		System.out.println("after advice: about to sound() ");
	}
	
	public void aroundToSound() {
		System.out.println("around advice: about to sound() ");
	}
}
