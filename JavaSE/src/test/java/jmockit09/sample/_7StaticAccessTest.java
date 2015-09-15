package jmockit09.sample;

import jmockit.target.StaticAccess;
import mockit.Expectations;

import org.junit.Assert;
import org.junit.Test;

/**
 * 有时我们需要在测试mock对象前对某些静态成员变量进行初始化的设值，
 * 但是这些静态成员变量往往是私有的，有时某些方法的调用中会间接调用静态私有方法。
 * 如何对这些静态私有变量或者静态私有方法进行mock呢？以下示例将示范这些用法
 * 
 * @author Ginge
 * 
 */
public class _7StaticAccessTest {

	@Test
	/*
	 * 对mock类型的静态私有成员变量进行设值的示例
	 */
	public void privateAccessField() {
		// 注意：这里使用了动态部分mock
		new Expectations(StaticAccess.class) {
			{
				// 对私有int类型的memberCounts进行设值
				this.setField(StaticAccess.class, "memberCounts", 2);
			}
		};

		Assert.assertEquals(5, StaticAccess.sumInternalCounts(3));
	}

	@Test
	/*
	 * 对mock类型的静态私有成员方法进行mock的示例
	 */
	public void privateAccessMethod() {
		// 注意：这里使用了动态部分mock
		new Expectations(StaticAccess.class) {
			{
				// 对私有方法进行mock
				this.invoke(StaticAccess.class, "getMemberCounts");
				result = 2;
			}
		};

		Assert.assertEquals(5, StaticAccess.sumInternalCounts(3));
	}

	@Test
	/*
	 * 直接对整个静态方法进行mock
	 */
	public void staticAccessMethod() {
		// 注意：这里使用了动态部分mock
		new Expectations(StaticAccess.class) {
			{
				StaticAccess.sumInternalCounts(3);
				result = 7;
			}
		};

		Assert.assertEquals(7, StaticAccess.sumInternalCounts(3));
	}
}