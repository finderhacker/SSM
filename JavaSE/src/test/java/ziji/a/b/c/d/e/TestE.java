package ziji.a.b.c.d.e;

import org.apache.log4j.Logger;
import org.junit.Test;


public class TestE {
	private static final Logger logger = Logger.getLogger(TestE.class);
	
	@Test
	public void aa(){
		logger.fatal("ziji.TestE");
		logger.error("ziji.TestE");
		logger.warn("ziji.TestE");
		logger.info("ziji.TestE");
		logger.debug("ziji.TestE");
		logger.trace("ziji.TestE");
	}
}
