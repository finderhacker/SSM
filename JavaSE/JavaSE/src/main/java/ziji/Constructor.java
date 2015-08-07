package ziji;

import java.beans.ConstructorProperties;

public class Constructor {
	private Integer i ;
	private String j ;
	private Integer k ;
	
	/*public Constructor() {
	}*/
	
	@ConstructorProperties({"i", "j", "k"})
	public Constructor(Integer a, String b, Integer c) {
		this.i = a; 
		this.j = b;
		this.k = c ;
	}

	@Override
	public String toString() {
		return "i = " + i + " ,  j = " + j + " , k = " + k ;
	}

	/**
	 * @param k the k to set
	 */
	public void setK(Integer k) {
		this.k = k;
	}
	
	
}
