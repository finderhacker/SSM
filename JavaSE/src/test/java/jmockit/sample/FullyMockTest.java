package jmockit.sample;

import jmockit.target.OfferPostAction;
import jmockit.target.WinportUrlServiceImpl;
import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Assert;
import org.junit.Test;

/**
 * 全部mock示例；一个被Mock注解的类型，默认是所有方法都被mock的。
 * 
 * @author Ginge
 * 
 */
public class FullyMockTest {

	@Mocked
	private WinportUrlServiceImpl winportUrlService = null;

	private OfferPostAction offerPostAction = new OfferPostAction();

	@Test
	public void testExpectations() {
		final String memberId = "test2009";
		// 步骤一、record （录制）
		// Expectations 中需要将希望mock的调用全部声明出来
		// NonStrictExpectations则不需要将希望mock的调用全部声明出来
		new Expectations() {
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				result = false; // 也可以是returns(false);
				// 总共可以调用的次数
				times = 1;

				winportUrlService.getWinportUrlThrowException(withAny(""));
			}
		};

		// 步骤二、replay 在此阶段，录制的方法可能会被调用
		Assert.assertEquals(false, offerPostAction.hasWinport(memberId));

		//如果没有被mock，下述的调用将会抛出异常，从而导致本unit test的失败；也就证明了方法默认是被 mock的
		try {
			offerPostAction.getWinportUrlThrowException(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			// fully mock，默认完全被mock，到这里就注定失败
			Assert.fail();
		}

	}

	@Test
	public void testNonStrict() {
		final String memberId = "test2009";
		// 步骤一、record （录制）
		// Expectations 中需要将希望mock的调用全部声明出来
		// NonStrictExpectations则不需要将希望mock的调用全部声明出来
		new NonStrictExpectations() {
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				result = false; // 也可以是returns(false);
				// 相比testExpectations方法
				// 少了， times = 1;
				// 也少了， winportUrlService.getWinportUrl(withAny(""));

			}
		};

		// 步骤二、replay 在此阶段，录制的方法可能会被调用
		Assert.assertEquals(false, offerPostAction.hasWinport(memberId));

		//如果没有被mock，下述的调用将会抛出异常，从而导致本unit test的失败；也就证明了方法默认是被 mock的
		try {
			offerPostAction.getWinportUrlThrowException(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			// fully mock，默认完全被mock，到这里就注定失败
			Assert.fail();
		}

	}
}