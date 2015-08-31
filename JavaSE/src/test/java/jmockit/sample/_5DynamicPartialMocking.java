package jmockit.sample;

import jmockit.target.OfferPostAction;
import jmockit.target.WinportUrlServiceImpl;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * 动态部分Mock示例，如果在录制阶段new Expectations不传入任何参数，
 * 那么声明为mock的类型的所有方法将会被mock。这种静态的mock非常局限，
 * 有时我们需要的是有条件的mock，在一定条件下mock才生效，在一定条件下却需要调用实际的方法。
 * 这时候我们就需要动态的mock。
 * <li>如果传入的是一个类， 那么该类型的所有方法但不包括父类的方法都会被mock。</li>
 * <li>如果传入的是一个实例，那么该类型的所有方法并包括父类的方法都会被mock。</li>
 * 
 * @author Ginge
 * 
 */
public class _5DynamicPartialMocking {
	@Mocked
	private WinportUrlServiceImpl winportUrlService = null;

	private OfferPostAction offerPostAction = new OfferPostAction();

	private final String memberId = "test2009";

	@Test
	public void dynamicallyMockAClass() {

		new Expectations(WinportUrlServiceImpl.class) {
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				result = false; // 也可以是returns(false);
				// 总共可以调用的次数
				times = 1;

				winportUrlService.getPostedOfferCounts(memberId);
				returns(999L);
				times = 1;
			}
		};
		// 因此xxx没有匹配到test2009，因此下面的调用中没有被mock
		Assert.assertEquals(true, offerPostAction.hasWinport("xxxx"));

		// 因为Expectation中声明只有一次mock，因此第一次的结果返回将是false
		Assert.assertEquals(false, offerPostAction.hasWinport(memberId));
		// 因为Expectation中声明只有一次mock，因此第二次的结果返回将是true
		Assert.assertEquals(true, offerPostAction.hasWinport(memberId));

		Assert.assertEquals(999L, offerPostAction.getPostedOfferCounts(memberId));
		// Expectations中参数是类的时候，只能mock当前类的方法，而不能mock父类的方法，因此以下的assert语句将会失败
		Assert.assertEquals(1000L,offerPostAction.getPostedOfferCounts(memberId));

	}

	@Test
	public void dynamicallyMockAnInstance() {
		new Expectations(new WinportUrlServiceImpl()) {
			{
				// 期望被mock的调用，以及被调用时返回的结果
				winportUrlService.hasWinport(memberId);
				result = false; // 也可以是returns(false);
				// 总共可以调用的次数
				times = 1;

				winportUrlService.getPostedOfferCounts(memberId);
				returns(999l);
				times = 1;
			}
		};

		// 因为Expectation中声明只有一次mock，因此第一次的结果返回将是false
		Assert.assertEquals(false, offerPostAction.hasWinport(memberId));
		// 因为Expectation中声明只有一次mock，因此第二次的结果返回将是true
		Assert.assertEquals(true, offerPostAction.hasWinport(memberId));

		// 因为Expectation中的参数是对象，因此整个继承树上的方法，除了java.lang.Object上的方法，都可以mock
		Assert.assertEquals(999L, offerPostAction.getPostedOfferCounts(memberId));
		Assert.assertEquals(1000L, offerPostAction.getPostedOfferCounts(memberId));

	}

}