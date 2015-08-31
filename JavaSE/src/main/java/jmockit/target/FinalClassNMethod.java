package jmockit.target;

/**
 * 只有一个final方法的final类，用于示例可以进行final方法的mock
 * 
 * @author Ginge
 * 
 */
public final class FinalClassNMethod {
	public final String getRealName(String memberId) {
		return "you";
	}
}