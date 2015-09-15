package jmockit09.sample;

import jmockit.target.InstanceInternalAccess;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.junit.Test;

/**
 * 有时我们需要在测试mock对象前对某些成员变量进行初始化的设值，
 * 但是这些成员变量往往是私有的，有时某些方法的调用中会间接调用私有方法。
 * 如何对这些私有变量或者私有方法进行mock呢？以下示例将示范这些用法。
 * 
 * @author Ginge
 * 
 */
public class _6PrivateAccessTest {
	private @Mocked
	InstanceInternalAccess instanceInternalAccess = null;

	@Test
	/*
	 * 对mock类型的私有成员变量进行设值的示例
	 */
	public void privateAccessField() {
		// 注意：这里使用了动态部分mock
		new Expectations(instanceInternalAccess) {
			{
				// 对私有int类型的memberCounts进行设值
				this.setField(instanceInternalAccess, "memberCounts", 2);
			}
		};

		Assert.assertEquals(5, instanceInternalAccess.sumInternalCounts(3));
	}

	@Test
	/*
	 * 对mock类型的私有成员方法进行mock的示例
	 */
	public void privateAccessMethod() {
		// 注意：这里使用了动态部分mock
		new Expectations(instanceInternalAccess) {
			{
				// 对私有方法进行mock
				this.invoke(instanceInternalAccess, "getMemberCounts");
				result = 2;
			}
		};

		Assert.assertEquals(5, instanceInternalAccess.sumInternalCounts(3));
	}
}