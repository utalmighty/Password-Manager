package com.PasswordManager.Spring.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// setting up our logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.PasswordManager.Spring.Aspect.Pointcuts.fullApp()")
	public void logInfo(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();
		String logMessage = methodName+">> ArgsPassed:"+ Arrays.toString(args);
		logger.info(logMessage.toString());
	}
	
	@AfterThrowing(pointcut = "com.PasswordManager.Spring.Aspect.Pointcuts.fullApp()",
			throwing = "exception")
	public void afterExceptionAdvice(JoinPoint joinPoint, Throwable exception) {
		String methodName = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();
		String message = methodName + ">> ArgsPassed:" + 
				Arrays.toString(args) + exception.getMessage();
		logger.warning(message); // Alert Team through mail
	}
}
