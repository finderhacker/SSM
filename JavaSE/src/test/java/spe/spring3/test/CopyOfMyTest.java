package spe.spring3.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CopyOfMyTest {

	@Resource
	private ApplicationContext applicationContext;
	
	@Test
//	@DirtiesContext
	public void test(){
		System.out.println(applicationContext);
	}
	
}
