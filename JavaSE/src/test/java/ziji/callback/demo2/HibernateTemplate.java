//模拟Spring中HibernateTemplate回调机制的代码 

package ziji.callback.demo2;

public class HibernateTemplate {

	public void execute(CallBack action) {
		getConnection();
		action.doCRUD();
		releaseConnection();
	}

	public void add() {
		execute(new CallBack() {
			public void doCRUD() {
				System.out.println("执行add操作...");
			}
		});
	    System.out.println("continue exec");  
	}

	public void getConnection() {
		System.out.println("获得连接...");
	}

	public void releaseConnection() {
		System.out.println("释放连接...");
	}

	
	public static void main(String[] args) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.add();
	}
}