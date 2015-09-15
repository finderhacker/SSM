package jmockit1X.scope;

import org.junit.Test;

public class OutScope{
	private SampleField sample;  //所有的实例都会被mock
	
	@Test
	public void test1(){
		//mock了
		sample.printA();
		sample.printStr();
	}
	
	@Test
	public void test2(){  //不会被mock，  如果是在MockScope中使用的话就会被mock
		//mock了
		SampleField sample2 = new SampleField();
		sample2.printA();
		sample2.printStr();
	}
	
	public static void main(String[] args) {
		//没走Junit、Jmockit。  所以不会mock
		SampleField sample2 = new SampleField();
		sample2.printA();
		sample2.printStr();
	}
	

}

