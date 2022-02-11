package com.PasswordManager.Spring.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcuts {
	
	@Pointcut("execution(* com.PasswordManager.Spring.Controller.*.*(..))")
	public void controller() {}
	
	@Pointcut("execution(* com.PasswordManager.Spring.DAO.*.*(..))")
	public void dao() {}
	
	@Pointcut("execution(* com.PasswordManager.Spring.Service.*.*(..))")
	public void service() {}
	
	@Pointcut("controller() || dao() || service()")
	public void fullApp() {}
}
