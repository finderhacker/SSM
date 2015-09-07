package init;

public class demo1 {

	static int i = 100 ;

	static{
		aa();
	}
	
	static int j =100 ;
	static String str = "abc";
	
	static void aa(){
		assert j!=100 ;
		
		System.out.println(i + "  " + j + " " +str) ;
	}
	
	public static void main(String[] args) {
		
	}
	
}
