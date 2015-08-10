package kaitao.spring3.chapter2;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void testHelloWord() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				//"classpath*:**/HelloWord2.xml",
				"kaitao/spring3/chapter2/HelloWord.xml");

		ac.getBean("h1");
	}
}