package com.kh.boot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAOP {


    //특정한 메서드나 패키지등의 join point
    // com.kh.boot.controller 패키지 하위 클래스의 모든 메서드에 전부 적용하겠다고 지점을 설정
    @Pointcut("execution(* com.kh.boot.controller..*.*(..))")
    private void cut(){};

    // cut메서드가 실행되는 지점 이전에 before() 메서드 실행
    //joinPoint : pointcut지점에 대한 정보가 들어있음
    @Before("cut()")
    public void before(JoinPoint joinPoint){

        //실행되는 메서드의 이름을 가져오기
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        //메서드에 들어가는 매게변수 배열을 읽어온다.
        Object[] args = joinPoint.getArgs();

        log.info("====================== START ==============================");
        log.info("====================== API Controller ==============================");
        log.info("Information          : " + methodSignature);
        log.info("Method Name          : " + method);
        log.info("Parameter          : " + Arrays.toString(args));

    }

    @AfterReturning(value = "cut()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj){
        log.info("====================== END ==============================");
        log.info("Object      : " + obj);
    }

    //대상 메서드를 감싸서 메서드 호출 전후에 Advice를 실행할 수 있다.
    @Around("cut()")
    public Object displayWhileLogInfo(ProceedingJoinPoint pjoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = pjoinPoint.proceed();

        long end = System.currentTimeMillis();

        long pTime = end - start;

        log.info("-------------------------------------");
        log.info("Information   : " + pjoinPoint.getSignature());
        log.info("Processiong Time   : " + pTime + "m/s");

        return result;
    }
}
