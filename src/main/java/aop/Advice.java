package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author tangxiaoshuang
 * @date 2018/1/8 9:53
 */
@Aspect
@Component
public class Advice {

    //切点
    @Pointcut(value = "execution(* scheduled.ScheduledTest.test(..))")
    public void method(){

    }

    @After(value = "method()")
    public void after(JoinPoint point) {
        System.out.println("after advice");
    }

    @Before(value = "method()")
    public void before(JoinPoint point) {
        System.out.println("before advice");
    }

    @Around(value = "method()")
    public Object around(ProceedingJoinPoint proceed) {
        Object obj = null;
        System.out.println("before around");
        try {
            Object[] objs = proceed.getArgs();
            obj = proceed.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after around");
        //切入方法的返回值 obj
        System.out.println(obj);
        return obj;
    }
}
