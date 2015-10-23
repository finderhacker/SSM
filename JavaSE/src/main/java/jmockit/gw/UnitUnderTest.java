package jmockit.gw;

public class UnitUnderTest {
	private final GuoWei abc = new GuoWei();

	public void doSomething() {
		int n = abc.getAge();

		for (int i = 0; i < n; i++) {
			String s;

			try {
				s = abc.getName();
				System.out.println("s = " + s);
			} catch (Exception e) {
				System.out.println("exception");
			}
		}
	}
}