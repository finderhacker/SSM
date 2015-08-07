package ziji;

import org.springframework.beans.factory.DisposableBean;

public class A implements DisposableBean{
	private B b ;
	
	public A(){
		System.out.println("A's construct");
	}
	
	public void start(){
		System.out.println("A start");
	}
	
	public void end(){
		System.out.println("A end");
	}

	/**
	 * @return the b
	 */
	public B getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(B b) {
		this.b = b;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("A interface end");			
	}
	
	//spring lookup-method
	public B createB() {
		return null  ;
	}
	
}
