package spe.spring3.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spe.spring3.test.in.A;
import spe.spring3.test.in.B;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MyTest {

	@Resource
	private ApplicationContext applicationContext;
	
	@Resource
	private A a;
	
	@Resource
	private B b;
	
	
	@Test
	@Timed(millis=12)
	@Repeat(50)
	public void test(){
		System.out.println(applicationContext);
		
		System.out.println(a.getB());
	}
	
}
