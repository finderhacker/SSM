package jmockit.gw;

import mockit.Capturing;
import mockit.Deencapsulation;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class TestedAndInjectable {

	@Tested
	private Outer outer;
	
	@Test
	public void test(@Injectable("outer") String s1){
//		Deencapsulation.setField(outer, "name", "s1");
		
		System.out.println(outer);
		System.out.println(outer.getName());
		System.out.println(outer.getInn1() + "  " + outer.getInn1().getName());
		System.out.println(outer.getInn2() + "  " + outer.getInn2().getName());
	}
	
	
	/*@Transactional
	public void test(){
		
	}*/
}
