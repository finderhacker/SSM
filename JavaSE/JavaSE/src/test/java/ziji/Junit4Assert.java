package ziji;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*; 

import org.junit.Test;

public class Junit4Assert {

	@Test
	public void test(){
		
		assertThat("123", not("123")) ;
	}
}
