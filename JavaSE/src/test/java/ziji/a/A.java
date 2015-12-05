package ziji.a;

import java.util.List;

import ziji.a.b.A2;

public class A {
	private String str;
	private List<A2> a2;//退款涉及到的商品信息

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @return the a2
	 */
	public List<A2> getA2() {
		return a2;
	}

	/**
	 * @param a2 the a2 to set
	 */
	public void setA2(List<A2> a2) {
		this.a2 = a2;
	}

	/**
	 * @param str
	 *            the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}
}