package corejava.chapt12.generic;

import java.util.ArrayList;
import java.util.List;

//不使用泛型
public class NonGeneric {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		list.add(1);
		
		for(Object a: list){
			System.out.println(a);
		}
		
		/*for(String a: list){
			System.out.println(a);
		}*/
		
	}
}
