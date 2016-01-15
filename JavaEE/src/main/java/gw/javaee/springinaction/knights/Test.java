package gw.javaee.springinaction.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws QuestException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-config.xml");
		Knight bean = context.getBean("knight", Knight.class);
		
		bean.embarkOnQuest();
	}
}
