package jmockit09.sample;

import jmockit.target.Constructor;
import mockit.Mock;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * 除了使用@MockUp的另外一种基于状态的mock测试的方式。
 * 
 * @author Ginge
 * 
 */
public class _AConstructorTest2 {
	@Mocked
	private Constructor constructor = null;

	@Test
	public void mockConstructor() {

		// 可以在任意时候把Mock装置起来，不用的时候可以脱下来
		Mockit.setUpMock(Constructor.class, new MockedConstructor());

		// 触发构造方法的mock
		new Constructor("Constructor");
		Assert.assertEquals("mock_Constructor", constructor.getRealName());

		// 注意咯，擦亮眼睛了，现在开始脱了
		Mockit.tearDownMocks(Constructor.class);

		constructor = new Constructor("Constructor");
		// 看到了吧，看到真容了
		Assert.assertEquals("real_Constructor", constructor.getRealName());

	}

	/**
	 * MockedConstructor相当于一个标志，具体名称不重要，重要的要它里面被@Mock注解的方法。如果有方法被注解了@Mock，
	 * 并且恰好方法的签名又和Mockit.setUpMock中声明的类型中的某个方法一样，那么对应的方法就被Mock
	 * 为了方便才把这个类的声明放到ConstructorTest2里面的，其实这个类可以放到任何地方
	 * 
	 * @author Ginge
	 * 
	 */
	public static class MockedConstructor {

		private String memberId;

		@Mock
		public void $init(String memberId) {
			this.memberId = "mock_" + memberId;
		}

		@Mock
		public String getRealName() {
			return this.memberId;
		}
	}

}