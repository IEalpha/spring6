package com.icbc.sd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class TimeLogAspect {

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("TimeLogAspect: " + joinPoint.getSignature().getName() + " cost " + (end - start) + "ms");
        return result;
    }
}
