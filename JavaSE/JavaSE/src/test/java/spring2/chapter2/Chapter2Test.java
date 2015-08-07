package spring2.chapter2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring2.chapter2.one.HelloBean;
import spring2.chapter2.two.Business;


public class Chapter2Test {

	@Test
	public void one(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:**/HelloBean.xml") ;
		
		HelloBean bean = ac.getBean("helloBean" , HelloBean.class);
		System.out.println(bean.getWord());
	}
	
	@Test
	public void two(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:**/Busienss.xml") ;
		Business bean = ac.getBean("business", Business.class);
		bean.save();
	}
	
}
