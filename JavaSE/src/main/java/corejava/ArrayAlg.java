package corejava;

public class ArrayAlg {

	public static <T> T getMiddle(T... a){
		return a[a.length/2];
	}
	
	
	public static void main(String[] args) {
		System.out.println(ArrayAlg.getMiddle("123","22", "444"));
		
		System.out.println(ArrayAlg.getMiddle("3.14", 0));
	}
}
