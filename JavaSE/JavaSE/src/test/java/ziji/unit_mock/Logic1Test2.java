package ziji.unit_mock;

import static org.junit.Assert.* ;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Logic1Test2 {

	Logic1 logic1 ;
	
	@Before
	public void init(){
		System.out.println("Before test...");
		logic1 = new Logic1() ;
	}
	
	@After
	public void destroy(){
		System.out.println("after test...");
	}
	
	@Test
	public void testAbs1(){
		int i = -15 ;
		System.out.println("run test1");
		assertEquals(-i , logic1.abs(i));
	}
	
	@Test
	@Ignore
	public void testAbs2(){
		int i = 100 ;
		System.out.println("run test2");
		assertEquals(i, logic1.abs(i));
	}
}
