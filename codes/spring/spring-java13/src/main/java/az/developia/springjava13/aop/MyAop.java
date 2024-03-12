package az.developia.springjava13.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {
	@Before("execution(* az.developia.springjava13.service.*.findAll(..))")
	public void doIt() {
		System.out.println("salam bu qabaga dusdu");
	}
}
