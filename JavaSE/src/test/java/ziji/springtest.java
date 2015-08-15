package ziji;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class springtest {
	private static final Logger logger = Logger.getLogger(springtest.class);
	
	
//	@Test
	public void metaData() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath*:**/*/a.xml");
        ((AbstractApplicationContext) ac).registerShutdownHook();

        
        logger.debug("1234567890");
	}
	
	
	@Test
	public void aa(){
		logger.fatal("ziji");
		logger.error("ziji");
		logger.warn("ziji");
		logger.info("ziji");
		logger.debug("ziji");
		logger.trace("ziji");
	}
	
	@Test
	public void str(){
		String str = "http://storage.jd.local/rebatepdf/%E5%8A%AA%E6%AF%94%E4%BA%9AZ9mini4-6%E6%9C%88%E8%BF%94%E5%88%A9%E6%A0%B8%E7%AE%97.pdf?Expires=1531361251&AccessKey=Lc9fPiQDFGeRBxJ3&Signature=9UZJmj4HIv72C%2BZUnA10BaLhuzc%3D" ;
		
		str = str.replaceFirst("http://storage\\.jd\\.local", "http://storage.jd.com") ;
		System.out.println(str);
		
	}
}