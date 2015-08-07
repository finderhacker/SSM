package ziji;

import org.junit.Test;

public class Junit4TimeoutTest {

	@Test(timeout=10)
	public void test(){
		try {
			Thread.sleep(11);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("123");
	}
}
