package ziji.unit_mock;

import static org.junit.Assert.* ;
import org.junit.Test;

public class Logic1Test {

	@Test
	public void testAbs(){
		Logic1 logic1 = new Logic1(); 
		
		int i = -15 ;
		
		assertEquals(i , logic1.abs(i));
		
	}
}
