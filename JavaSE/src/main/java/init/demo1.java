package init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo1 {

	static int i = 100 ;

	static demo1 dd = new demo1();
	
	static{
		aa();
		new demo1();
	}
	
	static double j =100d ;
	static String str = "abc";
	
	static void aa(){
//		assert j!=100 ;
		
		System.out.println(i + "  " + j + " " +str) ;
	}
	
	public static void main(String[] args) {
		
	}
	
	public demo1() {
		System.out.println("jhah");
		
		System.out.println(i + "  " + j + " " +str + "\n" + this + "  " + dd) ;
	}
	
	public void dd(){
		List<String> list = Arrays.asList("a", "b");
		
		
	}
	
}
