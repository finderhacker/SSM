package jmockit.sample;

import jmockit.target.WinportUrlService;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最简单的Mock示例；
 * 我们要在需要mock的类加上注解@Mocked或者@NonStrict；
 * 录制Expectations可有可没有。没有录制时，被mock的方法只会返回一个默认的值。
 * 验证Verifications可以有，也可以没有。
 * 
 * @author Ginge
 * 
 */
public class _1IntroductionTest {

	@Mocked
	// Mock的类型有Mocked和NonStrict，所有方法都被mock了
	private WinportUrlService winportUrlService = null;

	@Test
	public void testNoExpectations() {
		final String memberId = "test2009";
		Assert.assertEquals(false, 
				winportUrlService.hasWinport(memberId));
		
		Assert.assertNull("为null", winportUrlService.getWinportUrlThrowException(memberId));
	}

	@Test
	public void testWithExpectations() {
		final String memberId = "test2009";

		// 也可以是NonStrictExpectations//非严格的，所有声明的调用，声明的次数，返回的结果不用完全匹配
		new Expectations() {// 这种是严格的，所有声明的调用，声明的次数，返回的结果都会完全匹配
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				// 总共可以调用的次数
				result = false; // 也可以是returns(false);
				times = 1;
				
				winportUrlService.getWinportUrlThrowException("123");
				result = "123";
			}
		};

		// 步骤二、replay 在此阶段，录制的方法被调用
		Assert.assertEquals(false, winportUrlService.hasWinport(memberId));
		
		Assert.assertEquals("123", winportUrlService.getWinportUrlThrowException("123"));
	}
}