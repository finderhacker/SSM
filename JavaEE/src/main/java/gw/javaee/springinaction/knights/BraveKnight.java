package gw.javaee.springinaction.knights;

public class BraveKnight implements Knight{
	private Quest quest ;
	
	public BraveKnight(){/*为了AOP*/}
	
	public BraveKnight(Quest quest){
		this.quest = quest;
	}
	
	@Override
	public void embarkOnQuest() throws QuestException {
		quest.embark();
	}

}
