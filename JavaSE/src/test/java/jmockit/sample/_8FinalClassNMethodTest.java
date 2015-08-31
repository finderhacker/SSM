package jmockit.sample;

import jmockit.target.FinalClassNMethod;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * jmockit以外的其它mock实现都不能mock final的类和final方法，
 * 本例子示範mock final的类和final的方法。
 * 
 * @author Ginge
 * 
 */
public class _8FinalClassNMethodTest {
	@Mocked//这是一个final类
	private FinalClassNMethod FinalClassNMethod = null;

	@Test
	public void mockFinal() {

		new Expectations() {
			{
				FinalClassNMethod.getRealName(withAny(""));
				result = "FinalClassNMethod";
			}
		};

		Assert.assertEquals("FinalClassNMethod", FinalClassNMethod.getRealName(""));

	}
}