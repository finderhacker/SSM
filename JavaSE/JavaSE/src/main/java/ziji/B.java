package ziji;

import org.springframework.beans.factory.annotation.Autowired;

public class B {
	private String str ;
	
	private A a ;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * @return the a
	 */
	public A getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	@Autowired
	public void setA(A a) {
		this.a = a;
	}
	
	

}
