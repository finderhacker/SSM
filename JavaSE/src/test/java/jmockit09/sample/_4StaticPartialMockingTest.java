package jmockit09.sample;

import jmockit.target.OfferPostAction;
import jmockit.target.WinportUrlServiceImpl;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * 静态部分mock示例，静态Mock是通过注解@Mocked中的字段methods声明的。
 * 
 * @see
 * @author Ginge
 * 
 */
public class _4StaticPartialMockingTest {
	@Mocked(methods = { "[hH]asWinport" }, inverse = false)
	// 声明的方法可以使用正则表达式
	// methods 代表只有声明的方法才会进行mock, inverse
	// 代表是否反转声明，如果inverse=true，那么就是除了声明的方法不mock
	private WinportUrlServiceImpl winportUrlService = null;

	private OfferPostAction offerPostAction = new OfferPostAction();

	@Test
	public void testofferPostActionExecute() {
		final String memberId = "test2009";

		new Expectations() {
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				result = false; // 也可以是returns(false);
				// 总共可以调用的次数
				times = 1;
			}
		};

		// 步骤二、replay 在此阶段，录制的方法可能会被调用
		Assert.assertEquals(false, offerPostAction.hasWinport(memberId));

		try {
			// static partial mock，根据上述@Mocked注解的声明，WinportUrlServiceImpl#
			// getWinportUrlmock将不会被mock
			offerPostAction.getWinportUrlThrowException(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}