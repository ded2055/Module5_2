package com.goit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * Created by Ded on 20.07.2016.
 */
@Aspect
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.goit.Calculator.*(..))")
    private void selectAll() {
    }

    @After("selectAll()")
    public void logCalculatorsMethods(JoinPoint joinPoint){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        StringBuffer logMessage = new StringBuffer();
        logMessage.append(joinPoint.getTarget().getClass().getName());
        logMessage.append(".");
        logMessage.append(joinPoint.getSignature().getName());
        logMessage.append("(");

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }

        logMessage.append(")");
        logMessage.append(" execution time: ");
        logMessage.append(stopWatch.getTotalTimeMillis());
        logMessage.append(" ms");
        logger.info(logMessage.toString());

    }

}
