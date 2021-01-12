package com.diaz.practica04.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private Log LOG;
	
	private Long tx;
	
	@Around("execution(* com.diaz.practica03.daos.*Dao*.*(..))")
	public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {

		LOG = LogFactory.getLog(joinPoint.getTarget().getClass());
		
		Object result =  null;
		Long currTime = System.currentTimeMillis();
		tx = System.currentTimeMillis();
		
		LOG.info("tx["+tx+"] --- INICIO DEL REQUEST ---");
		
		String metodo = "tx["+tx+"] - " + joinPoint.getSignature().getName();
		
		try {
			result = joinPoint.proceed();
        } catch (Throwable e) {
        	LOG.error(e.getMessage());
        }
		
		LOG.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
		
		LOG.info("tx["+tx+"] --- FIN DEL REQUEST ---");
		
		return result;

	}

}
