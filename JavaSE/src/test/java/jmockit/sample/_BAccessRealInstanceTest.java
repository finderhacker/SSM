package jmockit.sample;

import jmockit.target.Constructor;
import mockit.Mock;
import mockit.Mockit;

import org.junit.Assert;
import org.junit.Test;

/**
 * mock实例中it代表实际的mock对象
 * 
 * @author Ginge
 * 
 */
public class _BAccessRealInstanceTest {
	//注意，这里少了@Mocked
	private Constructor constructor = new Constructor("");

	@Test
	public void mockConstructor() {

		// 可以在任意时候把Mock装置起来，不用的时候可以脱下来
		Mockit.setUpMock(Constructor.class, new MockedConstructor());

		//参数没有匹配到，直接返回了mock
		Assert.assertEquals("mock", constructor.getRealInstanceName(""));
		//参数匹配到real，返回了实际对象方法调用的结果
		Assert.assertEquals("real_m_real", constructor.getRealInstanceName("real"));

	}

	/**
	 * MockedConstructor相当于一个标志，具体名称不重要，重要的是它里面被@Mock注解的方法。如果有方法被注解了@Mock，
	 * 并且恰好方法的签名又和Mockit.setUpMock中声明的类型中的某个方法一样，那么对应的方法就被Mock
	 * 为了方便才把这个类的声明放到ConstructorTest2里面的，其实这个类可以放到任何地方
	 * 
	 * @author Ginge
	 * 
	 */
	public static class MockedConstructor {

		//it属性表示实际对象
		public Constructor it;

		@Mock(reentrant = true)//reentrant表示是否可以访问实际对象
		public String getRealInstanceName(String m) {
			if ("real".equals(m)) {
				return it.getRealInstanceName(m);
			} else {
				return "mock";
			}

		}
	}

}