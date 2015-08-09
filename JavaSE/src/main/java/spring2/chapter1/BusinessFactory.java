package spring2.chapter1;

import java.util.Properties;

public class BusinessFactory {
	private Business business ;
	private IDeviceWriter writer ;
	
	public BusinessFactory() throws Exception{
		System.out.println(this.getClass().getClassLoader());
		
		Properties p = new Properties() ;
//		p.load(this.getClass().getResourceAsStream("/spring2/chapter1/business.properties"));  //取到系统类加载器就能从classpath加载
		p.load(ClassLoader.getSystemResourceAsStream("spring2/chapter1/business.properties"));  //从classpath加载
		String businessClass = p.getProperty("business") ;
		String writerClass = p.getProperty("writer") ;
		
		IDeviceWriter c = (IDeviceWriter) Class.forName(writerClass).newInstance();
		Business a = (Business) Class.forName(businessClass).getConstructor(IDeviceWriter.class).newInstance(c) ;
		
		this.business = a ;
		this.writer = c;
	}
	
	public Business getBusiness() throws Exception{
		return business;
	}

	/**
	 * @return the writer
	 */
	public IDeviceWriter getWriter() {
		return writer;
	}
}
