package com.baizhi.aspect;

import com.baizhi.annotation.RedisCacheAnnotation;
import com.baizhi.util.SerializeUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Aspect
@Configuration
public class RedisCacheAspect {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Around("execution(* com.baizhi.service.*.query*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //judge where the method has the annotation , if it has , use redis , if it hasn't , don't use redis
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        boolean annotationPresent = methodSignature.getMethod().isAnnotationPresent(RedisCacheAnnotation.class);
        System.out.println(annotationPresent);
        if (annotationPresent){
            //get the class name(id)
            String id = proceedingJoinPoint.getTarget().getClass().getName();
            //get the method name
            String methodName = proceedingJoinPoint.getSignature().getName();
            //get the args
            Object[] args = proceedingJoinPoint.getArgs();
            StringBuilder stringBuilder = new StringBuilder();
            for (Object arg : args) {
                stringBuilder.append(arg);
            }
            //get the key
            String key = methodName+stringBuilder.toString();
            //as the result
            Object result = null;
            //judge whether the redis has the id , if it has , just pick up the result , if it hasn't , put the result into the redis
            Boolean aBoolean = stringRedisTemplate.opsForHash().hasKey(id, key);
            if (aBoolean){
                System.out.println("==========pick up from the redis==========");
                String o = (String) stringRedisTemplate.opsForHash().get(id, key);
                Object o1 = SerializeUtils.serializeToObject(o);
                result = o1;
            }else{
                System.out.println("==========put the result into the redis==========");
                result = proceedingJoinPoint.proceed();
                stringRedisTemplate.opsForHash().put(id,key,SerializeUtils.serialize(result));
            }
            return result;
        }else {
            return proceedingJoinPoint.proceed();
        }
    }
}
