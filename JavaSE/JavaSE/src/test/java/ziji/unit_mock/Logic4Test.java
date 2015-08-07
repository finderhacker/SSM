package ziji.unit_mock;

import org.junit.Test;

public class Logic4Test {

	@Test(expected = Logic4.SpecialException.class)
	public void testTriggerException() throws Logic4.SpecialException {
		Logic4 logic4 = new Logic4();

		logic4.testException(false); // 单元测试失败
//		logic4.testException(true); // 单元测试成功
	}
}
