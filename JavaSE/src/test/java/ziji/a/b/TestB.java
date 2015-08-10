package ziji.a.b;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestB {
	private int i = 10;
	
	private void pp(){
		System.out.println("PPP");
	}
	
	class Inner{
		private int i = 50;
		
		//构造方法，默认会有一个外围类对象
		Inner(char c, TestB tt){}
		Inner(){}
		
		void pint(){
			System.out.println(i + "  " + TestB.this.i);
			pp();
			
		}
	}
	

	@Test
	public void a(){
		TestB testB = new TestB();
		TestB.Inner inner = testB.new Inner();
		
		System.out.println(Arrays.toString(testB.getClass().getDeclaredMethods()));
		System.out.println(Arrays.toString(inner.getClass().getDeclaredFields()));
		
		
		Nested nested = new Nested();
		nested.pint();
	}
	
	private static class Nested{
		private int i = 99;
		
		//构造方法
		Nested(){}
		Nested(char c){}
		
		void pint(){
			System.out.println(i);
		}
			
	}
}
