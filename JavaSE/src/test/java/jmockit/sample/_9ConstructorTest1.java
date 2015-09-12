package jmockit.sample;

import jmockit.target.Constructor;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * 好了，到此为止，之前所有的mock都是基于行为的mock，以下对构造方法的mock的示例是基于状态的。
 * 我认为基于行为的mock是站在目标测试代码外面的角度的，而基于状态的是站在目标测试代码内部的。
 * 我们可以对传入的参数进行检查、匹配，才返回某些结果。
 * 
 * @author Ginge
 * 
 */
public class _9ConstructorTest1 {

	@Mocked
	private Constructor constructor = null;

	@Test
	public void mockConstructor() {
		new Expectations() {
			{
				// MockUp可以对应一个类或者接口，如果它的子类中有方法被注解了@Mock，
				// 并且恰好方法的签名又和传入的泛型的类型中某个方法一样，那么对应的方法就被Mock
				new MockUp<Constructor>() {

					private String memberId;

					// $init表示构造方法
					@Mock
					public void $init(String memberId) {
						this.memberId = "mock_" + memberId;
					}

					@Mock
					public String getRealName() {
						return this.memberId;
					}

				};
			}

		};

		//触发构造方法的mock
		constructor = new Constructor("Constructor");

		Assert.assertEquals("mock_Constructor", constructor.getRealName());

	}
}