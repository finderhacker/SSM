package assertion;

public class Test {
	public static void main(String[] args) {
		int a = 5;
		// 断言a>3
		assert a > 3;

		while(true){
			System.out.println("123");
		}
		
		// 断言a<3,否则显示a不小于3，且a的值为：" + a
//		assert a < 3 : "a不小于3" + "，且a的值为：" + a;
		
//		throw new AssertionError();
	}
}
