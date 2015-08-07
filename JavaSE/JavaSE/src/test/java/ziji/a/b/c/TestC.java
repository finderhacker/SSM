package ziji.a.b.c;

import org.apache.log4j.Logger;
import org.junit.Test;


public class TestC {
	private static final Logger logger = Logger.getLogger(TestC.class);
	
	@Test
	public void aa(){
		logger.fatal("ziji.TestC");
		logger.error("ziji.TestC");
		logger.warn("ziji.TestC");
		logger.info("ziji.TestC");
		logger.debug("ziji.TestC");
		logger.trace("ziji.TestC");
	}
}
