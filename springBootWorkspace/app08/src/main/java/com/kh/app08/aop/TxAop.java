package com.kh.app08.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAop {

    @Around("어노테이션( @Transactional )")
    public void m01(ProceedingJoinPoint targetMethod) throws Throwable {
//        conn = ???;
//        try{
//            targetMethod.proceed(conn);
//            conn.commit();
//        }catch(Exception e){
//            conn.rollback();
//        }fianlly{
//            conn.close();
//        }
    }

}
