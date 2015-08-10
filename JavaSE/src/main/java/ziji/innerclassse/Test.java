package ziji.innerclassse;

import java.math.BigDecimal;

public class Test {
	private String str = "Test";

	class A {
		private String str = "Test.A";

		private BigDecimal Aa() {
			System.out.println("Test.A.Aa");
			
			return new BigDecimal("123");
		}

		class B {
			// private String str = "Test.A.B";

			void a() {
				System.out.println(str);

				System.out.println(A.this.str);

				System.out.println(Test.A.this.str);
				
				System.out.println(Test.this.str);

				Aa();
			}
		}
	}
	
	static class C{
		private String b = "Test.C";
		
		void print(){
//			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		Test.A a = test.new A(); 
		Test.A.B b = a.new B();
		
		b.a();
	}
}
