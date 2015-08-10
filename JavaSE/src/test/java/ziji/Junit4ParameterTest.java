package ziji;

import java.util.Arrays;
import java.util.Collection;





import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Junit4ParameterTest {
	private int i;
	private String j;

	public Junit4ParameterTest(int i, String j) {
		this.i = i;
		this.j = j;
	}

	@Parameters
	public static Collection feed() {
		Object[][] obj = { { 3, "c" }, { 1, "w" }, { 2, "a" } };

		return Arrays.asList(obj);

	}

	@Test
	public void test() {
		System.out.println(i + "  " + j);

		Assert.assertTrue("要true", false);
	}
}
