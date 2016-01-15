package corejava.chapt12.generic;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		checkCase();
		
		varargs();
		
		Interval<GregorianCalendar> p = new Interval<GregorianCalendar>(); 
	}
	
	
	//通过通配转换，创建泛型数组
	private static void checkCase(){
		List<String>[] lists = (ArrayList<String>[])new ArrayList<?>[2];
		
		List<String> l1 = new ArrayList<String>();
		l1.add("123"); l1.add("456");
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(123); l2.add(456);
		
//		lists[0] = l1; lists[1] = l2;  Type mismatch: cannot convert from List<Integer> to List<String>
		
		//由于数组的协变性可以用一个共同的父类绕过去
		Object[] obj = lists;
		obj[0] = l1; obj[1] = l2;
		
		//这就导致后续类型转换异常
		List<String> re1 = lists[0];
		List<String> re2 = lists[1];
//		List<Integer> re22 = lists[1];  //Type mismatch: cannot convert from List<String> to List<Integer>

		//当用到List<Integer>中的元素时，就会有checkcase
		String string = re2.get(0);  //Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	}
	
	private static void varargs() {
		List<String>[] lists = array(new ArrayList<String>(), new ArrayList<String>());
		
		//以下同checkCase()中的一样
		List<String> l1 = new ArrayList<String>();
		l1.add("123"); l1.add("456");
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(123); l2.add(456);
		
//		lists[0] = l1; lists[1] = l2;  Type mismatch: cannot convert from List<Integer> to List<String>
		
		//由于数组的协变性可以用一个共同的父类绕过去
		Object[] obj = lists;
		obj[0] = l1; obj[1] = l2;
		
		//这就导致后续类型转换异常
		List<String> re1 = lists[0];
		List<String> re2 = lists[1];
//		List<Integer> re22 = lists[1];  //Type mismatch: cannot convert from List<String> to List<Integer>

		//当用到List<Integer>中的元素时，就会有checkcase
		String string = re2.get(0);  //Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	}
	
	//支持varargs，虚拟机还得创建一个泛型数组
	private static <T> T[] array(T... a){
		return a;
	}
}
