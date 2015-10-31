package jmockit1X.expectation;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Ignore;
import org.junit.Test;

public class MultipleExpectations {
	
	@Test
	public void one(@Mocked final Demo d){
		new Expectations() {{
			d.getDesc(anyString); result = "one";
			d.getDesc("1"); result = "two";
		}};
		
		Demo d1 = new Demo();
		System.out.println(d1.getDesc("1"));
		
		Demo d2 = new Demo();
		System.out.println(d1.getDesc("1"));
		System.out.println(d2.getDesc("1"));
		
		System.out.println("one end");
	}
	
	
	@Test
	public void one2(@Mocked final Demo d){
		new Expectations() {{
			d.getDesc(anyString); result = "one";
		}};
		
		Demo d1 = new Demo();
		System.out.println(d1.getDesc("1"));
		
		new Expectations() {{
			d.getDesc("1"); result = "two";
		}};
		
		Demo d2 = new Demo();
		System.out.println(d1.getDesc("1"));
		System.out.println(d2.getDesc("1"));
		
		System.out.println("one2 end");
	}
	
	
	@Test
	public void two(@Mocked final Demo d){
		new Expectations() {{
			d.getDesc("1"); result = "two";
			d.getDesc(anyString); result = "one";
		}};
		
		Demo d1 = new Demo();
		System.out.println(d1.getDesc("1"));
		
		Demo d2 = new Demo();
		System.out.println(d1.getDesc("1"));
		System.out.println(d2.getDesc("1"));
		
		System.out.println("two end");
	}
	
	@Test
	public void two2(@Mocked final Demo d){
		new Expectations() {{
			d.getDesc("1"); result = "two";
		}};
		
		Demo d1 = new Demo();
		System.out.println(d1.getDesc("1"));
		
		new Expectations() {{
			d.getDesc(anyString); result = "one";
		}};
		
		Demo d2 = new Demo();
		System.out.println(d1.getDesc("1"));
		System.out.println(d2.getDesc("1"));
		
		System.out.println("two end");
	}
}


class Demo{
	private String desc;

	public Demo() {
	}

	/**
	 * @return the desc
	 */
	public String getDesc(String str) {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
