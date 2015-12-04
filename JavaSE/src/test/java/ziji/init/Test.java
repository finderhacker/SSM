package ziji.init;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	{
		System.out.println("haha!");
	}
	
	
	public static void main(String[] args) throws Exception {
		//说明new与反射 都是走正常的<init>流程
		new Test();
		new Test();
		new Test();
		
		Constructor<?> con = (Test.class.getConstructors())[0];
		con.newInstance(null);
		con.newInstance(null);
		
		
		//字段不具有多态性。
		System.out.println(new A());  //输出classAA
		System.out.println(new B());  //输出classAA
	}
}



class A{
	public String str="A";
	
	@Override
	public String toString() {
		System.out.println(this.getClass());
		return "classA" + str;
	}
	
}

class B extends A{
	
	public String str="B";
}