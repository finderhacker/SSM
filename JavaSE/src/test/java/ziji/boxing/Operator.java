package ziji.boxing;

import org.junit.Test;

public class Operator {

	@Test
	public void test1(){
		int i1 = 10;  //istore_1
		Integer i2 = 10;  //astore_2
		Integer i3 = 10 ; //astore_3
		Integer i4 = null ;  //astore  4   null
		
		System.out.println(i1 == i2);  //有原生类型，或拆箱
		System.out.println(i2 == i3);  //直接的引用比较
		System.out.println(i2 > i3);  //全部拆箱比较
		
		System.out.println(i4 + 1);  //拆箱时空指针异常
	}
}
