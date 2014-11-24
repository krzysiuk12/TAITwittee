package pl.edu.agh.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Aspect
@Component
public class LoggerAspect {

    private static final String SEPARATOR = " --- ";
    private static final String BEFORE_EXECUTION = "Before execution" + SEPARATOR;
    private static final String AFTER_EXECUTION = "After execution" + SEPARATOR;
    private static final String EXCEPTION = "Exception" + SEPARATOR;

    private Logger logger = Logger.getLogger("[MAIN LOGGER - LOGGER ASPECT]");

    @Before("pl.edu.agh.aspects.pointcuts.PointcutDefinitions.allServiceMethodsPointcut()")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder(BEFORE_EXECUTION);
        builder.append(joinPoint.getTarget().getClass().getSimpleName()).append(SEPARATOR);
        builder.append(joinPoint.getSignature().getName()).append(SEPARATOR);
        builder.append(Arrays.toString(joinPoint.getArgs()));
        logger.info(builder.toString());
    }

    @AfterThrowing(pointcut = "pl.edu.agh.aspects.pointcuts.PointcutDefinitions.allServiceMethodsPointcut()", throwing = "ex")
    public void logAfterThrowingException(JoinPoint joinPoint, Exception ex) {
        StringBuilder builder = new StringBuilder(AFTER_EXECUTION);
        builder.append(ex.getClass().getSimpleName()).append(SEPARATOR);
        builder.append(ex.getMessage()).append(SEPARATOR);
        logger.error(builder.toString(), ex);
    }

    @After("pl.edu.agh.aspects.pointcuts.PointcutDefinitions.allServiceMethodsPointcut()")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder(AFTER_EXECUTION);
        builder.append(joinPoint.getTarget().getClass().getSimpleName()).append(SEPARATOR);
        builder.append(joinPoint.getSignature().getName()).append(SEPARATOR);
        logger.info(builder.toString());
    }

}
