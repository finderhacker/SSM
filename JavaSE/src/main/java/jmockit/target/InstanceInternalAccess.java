package jmockit.target;

/**
 * 示例一个公共方法内部调用了一个私有方法；示例私有成员变量的设值。
 * 
 * @author Ginge
 * 
 */
public class InstanceInternalAccess {
	private int memberCounts;

	private int getMemberCounts() {
		return this.memberCounts;
	}

	/**
	 * 把传入的count和内部定义的私有int类型的memberCounts的值相加，返回相加的结果。
	 * 
	 * @param count
	 * @return
	 */
	public int sumInternalCounts(int count) {
		int myCount = this.getMemberCounts();
		return myCount + count;
	}
}