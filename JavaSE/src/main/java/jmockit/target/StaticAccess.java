package jmockit.target;

public class StaticAccess {

	private static int memberCounts;

	private static int getMemberCounts() {
		return memberCounts;
	}

	/**
	 * 把传入的count和内部定义的私有int类型的memberCounts的值相加，返回相加的结果。
	 * 
	 * @param count
	 * @return
	 */
	public static int sumInternalCounts(int count) {
		int myCount = getMemberCounts();
		return myCount + count;
	}

}