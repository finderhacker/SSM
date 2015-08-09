package spring2.chapter2.two;

public class Business {
	private IDeviceWriter writer ;
	
	public Business(IDeviceWriter writer) {
		this.writer = writer ;
	}
	
	public void save(){
		writer.saveToDevice(); 
	}
	
	static{
		System.out.println("aaa");
	}
	
	{
	 System.out.println("bbb");	
	}
}
