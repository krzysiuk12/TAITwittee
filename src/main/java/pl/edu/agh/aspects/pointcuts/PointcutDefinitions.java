package pl.edu.agh.aspects.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Aspect
public class PointcutDefinitions {

    @Pointcut("within(pl.edu.agh.services.*)")
    public void allServiceMethodsPointcut() {}

}
