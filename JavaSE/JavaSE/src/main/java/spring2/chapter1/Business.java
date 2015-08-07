package spring2.chapter1;

public class Business {
	private IDeviceWriter writer ;
	
	public Business(IDeviceWriter writer) {
		this.writer = writer ;
	}
	
	public void save(){
		writer.saveToDevice(); 
	}
}
