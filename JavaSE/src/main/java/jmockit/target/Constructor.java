package jmockit.target;

public class Constructor {

	private String memberId;

	public Constructor(String memberId) {
		this.memberId = memberId;
	}

	public String getRealName() {
		return "real_" + this.memberId;
	}

	public String getRealInstanceName(String m) {
		return "real_m_" + m;
	}

}