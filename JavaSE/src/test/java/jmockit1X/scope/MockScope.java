package jmockit1X.scope;

import org.junit.Test;

import mockit.Mocked;

public class MockScope {
	@Mocked
	private SampleField sample;  //在MockScope的context上吧，  所有的实例都会被mock
	
	@Test
	public void testField1(){
		//mock了
		sample.printA();
		sample.printStr();
	}
	
	@Test
	public void testField2(){
		//mock了
		SampleField sample2 = new SampleField();
		sample2.printA();
		sample2.printStr();
	}
	
	@Test
	public void testField3(){  //此处OutScope中的SampleField也会被mock。  但单独Junit ， OutScope不会被mock。
		OutScope outScope = new OutScope();
		outScope.test2();
	}
	
	@Test
	public void testParam1(@Mocked final SampleParam sampleParam){  //在方法的scope中被mock
		sampleParam.printA();
		sampleParam.printStr();
		
		SampleParam sampleParam1 = new SampleParam(); //被mock
		sampleParam1.printA();
		sampleParam1.printStr();
		
		
		testParam3();  //这任然是在testParam1范围内
	}
	
	@Test
	public void testParam2(){
		SampleParam sampleParam = new SampleParam();  //不再testParam1内不会被mock
		sampleParam.printA();
		sampleParam.printStr();
	}
	
	private void testParam3(){  //被testParam1调用
		SampleParam sampleParam = new SampleParam();  //也就是在testParam1内被mock了
		sampleParam.printA();
		sampleParam.printStr();
	}
	
	
	public static void main(String[] args) {
		//没走Junit、Jmockit。  所以不会mock
		SampleField sample2 = new SampleField();
		sample2.printA();
		sample2.printStr();
		
		SampleParam sampleParam = new SampleParam();
		sampleParam.printA();
		sampleParam.printStr();
	}
	
}

