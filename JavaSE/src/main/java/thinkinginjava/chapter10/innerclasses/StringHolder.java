package thinkinginjava.chapter10.innerclasses;

public class StringHolder {

	private String str ;
	
	StringHolder(String str){
		this.str = str;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StringHolder [str=" + str + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
