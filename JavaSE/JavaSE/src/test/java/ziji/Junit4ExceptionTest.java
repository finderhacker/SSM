package ziji;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class Junit4ExceptionTest {
	
	private String str ;
	
	@Before
	public void init(){
		str = null ;
	}
	
	@Test(expected=NullPointerException.class)
	public void test(){
		System.out.println("23");
		assertNotNull(str.getBytes());
	}
	
}
