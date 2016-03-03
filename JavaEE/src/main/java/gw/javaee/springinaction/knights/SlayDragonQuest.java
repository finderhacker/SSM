package gw.javaee.springinaction.knights;

public class SlayDragonQuest implements Quest {

	@Override
	public void embark() {
		System.out.printf("%s%n", "kill dragon");
	}

}
