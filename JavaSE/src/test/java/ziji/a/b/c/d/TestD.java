package ziji.a.b.c.d;

import org.apache.log4j.Logger;
import org.junit.Test;


public class TestD {
	private static final Logger logger = Logger.getLogger(TestD.class);
	
	@Test
	public void aa(){
		logger.fatal("ziji.TestD");
		logger.error("ziji.TestD");
		logger.warn("ziji.TestD");
		logger.info("ziji.TestD");
		logger.debug("ziji.TestD");
		logger.trace("ziji.TestD");
	}
}
