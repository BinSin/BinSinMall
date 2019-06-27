package com.binsin.helloAOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {

	@Pointcut("execution( void com.binsin.helloAOP.*.sound() )")
	private void selectSound() { // pointcut에 대한 id : signature 라고 한다.
		
	}
	
	@Before("selectSound()")
	public void beforeToSound() {
		System.out.println("before advice: about to sound() ");
	}
	
	@After("selectSound()")
	public void afterToSound() {
		System.out.println("after advice: about to sound() ");
	}
	
	// around 사용 시 다른 aspect 사용에 오류가 있다.
	//@Around("selectSound()")
	public void aroundToSound() {
		System.out.println("around advice: about to sound() ");
	}
}
