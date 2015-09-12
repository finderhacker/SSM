package jmockit.sample;

import jmockit.target.OfferPostAction;
import jmockit.target.WinportUrlServiceImpl;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.junit.Assert;
import org.junit.Test;
/**
 * 一个完整的Mock会有三个步骤
 * 步骤一、record （录制）；
 * 步骤二、replay 在此阶段，录制的方法可能会被调用；
 * 步骤三、验证。如果是Expectations就没有必要做Verifications了。
 * 
 * @author Ginge
 *
 */
public class _2RecordReplayVerificationTest {

	@Mocked
	private WinportUrlServiceImpl winportUrlService = null;

	private OfferPostAction offerPostAction = new OfferPostAction();

	@Test
	public void testofferPostActionExecute() {
		final String memberId = "test2009";
		// 步骤一、record （录制）
		new NonStrictExpectations() {
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				result = false; // 也可以是returns(false);
				// 总共可以调用的次数
				times = 1;
			}
		};

		// 步骤二、replay 在此阶段，录制的方法可能会被调用
		Assert.assertEquals(false, offerPostAction.hasWinport("test2009"));
		
		//fully mock，默认完全被mock，到这里就注定不会失败
		Assert.assertNull("为null", offerPostAction.getWinportUrlThrowException(memberId));

		// 步骤三、验证步骤二中，mock方法是否被调用，本步骤可以省略
		new Verifications() {
			{
				winportUrlService.hasWinport(withAny(""));
				times = 1;
			}
		};
	}
}