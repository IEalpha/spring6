package com.icbc.sd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnoLogAspect {

    @Pointcut("execution(* com.icbc.sd.aop.UserService.addUser(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        System.out.println(signature.getDeclaringTypeName());
        Class declaringType = signature.getDeclaringType();
        System.out.println(declaringType);
        System.out.println(signature.getName());
        int modifiers = signature.getModifiers();
        System.out.println(modifiers);
        //获取目标方法的返回值类型
        Class returnType = signature.getDeclaringType();
        System.out.println("============");
        System.out.println(returnType);

        long start = System.currentTimeMillis();
        System.out.println("AnnoLogAspect: start");
        Object result = null;
        try {
            result = pjp.proceed();
            System.out.println(result.getClass());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("AnnoLogAspect: end, cost " + (end - start) + "ms");
        return result;
    }
}
