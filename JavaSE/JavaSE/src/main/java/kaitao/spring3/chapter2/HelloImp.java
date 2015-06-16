package kaitao.spring3.chapter2;

public class HelloImp implements HelloApi {

	
	
	private HelloImp() {
		super();
//		System.out.println("gwgw");
	}

	@Override
	public void sayHello() {
		System.out.println("Hello Spring!");
	}

}
