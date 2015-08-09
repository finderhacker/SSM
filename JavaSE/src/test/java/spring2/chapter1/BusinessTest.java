package spring2.chapter1;

import org.junit.Test;

public class BusinessTest {

	public void testBuiness(){
		Business b = new Business(new UsbDiskWriter()) ;
		b.save();
	}
	
	@Test
	public void testBusinessFactory() throws Exception{
		BusinessFactory bf = new BusinessFactory() ;
		bf.getBusiness().save();
		
		
		System.out.println(System.getProperty("java.ext.dirs") + "\n" +
				System.getProperty("java.class.path")
		);
		
		
	}
	
	
	@Test
	public void ziji(){
		System.out.println(null == null);
	}
}
