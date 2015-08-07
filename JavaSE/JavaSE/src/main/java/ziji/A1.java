package ziji;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;

public class A1 implements DisposableBean, ApplicationContextAware, Lifecycle{
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext ;
	}
	
	//A：singleton  B：prototype， 每次获取的B是不同的
	public B createB() {
		return applicationContext.getBean("b",  B.class) ;
	}
	
	private B b ;
	//A：singleton  B：prototype，每次获取的B都是同一个
	public B getB() {
		return b;
	}
	
	public A1(){
		System.out.println("A's construct");
	}
	
	public void start(){
		System.out.println("A start");
	}
	
	public void end(){
		System.out.println("A end");
	}


	/**
	 * @param b the b to set
	 */
	public void setB(B b) {
		this.b = b;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("A interface end");			
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
