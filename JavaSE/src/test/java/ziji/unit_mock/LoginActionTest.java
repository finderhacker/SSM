package ziji.unit_mock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.junit.Assert;
import org.junit.Test;

public class LoginActionTest {

	// 还记得JUnit单元测试里面的注解吗？？
	@Test
	public void testLoginSuccessedExample() throws DatabaseConnException {
		Mockery context = new Mockery();
		
		final DatabaseConnection databaseConnection = context.mock(DatabaseConnection.class);
		final DatabaseManager databaseManager = context.mock(DatabaseManager.class);
		
		LoginAction loginAction = new LoginAction();
		loginAction.setDatabaseConnection(databaseConnection);
		loginAction.setDatabaseManager(databaseManager);
		
		context.checking(new Expectations(){
			{
				oneOf(databaseManager).isExistAccount("root", "root");
				will(returnValue(true));
				
				
				oneOf(databaseConnection).isConnectioned();
				will(returnValue(true));
				
			}
		});
		
		
		String s = loginAction.login("root", "root") ;
		
		context.assertIsSatisfied();
		
		Assert.assertEquals(s, "login successed");
	}

	@Test
	public void testLoginFailedExample() throws DatabaseConnException {
		Mockery context = new Mockery();

		final DatabaseConnection databaseConnection = context
				.mock(DatabaseConnection.class);
		final DatabaseManager databaseManager = context
				.mock(DatabaseManager.class);

		LoginAction loginAction = new LoginAction();
		loginAction.setDatabaseConnection(databaseConnection);
		loginAction.setDatabaseManager(databaseManager);

		// 注意顺序的设置，跟login方法中两个方法的调用顺序有要求
		final Sequence seq = context.sequence("loginActionTest");

		context.checking(new Expectations() {
			{
				// 此处期望先调用isConnectioned，然后isExistAccount方法
				// 看看login方法中是否也是这样的呢，不是的话，测试就会失败
				oneOf(databaseConnection).isConnectioned();
				inSequence(seq);
				will(returnValue(true));
				
				oneOf(databaseManager).isExistAccount("root", "root");
				inSequence(seq);
				will(returnValue(false));
			}
		});

		String s = loginAction.login("root", "root");

		context.assertIsSatisfied();

		Assert.assertSame("login failed", s);
	}

	// 测试抛出异常的情况
	@Test(expected = DatabaseConnException.class)
	public void testLoginThrowsDatabaseConnException()
			throws DatabaseConnException {
		Mockery context = new Mockery();

		final DatabaseConnection databaseConnection = context
				.mock(DatabaseConnection.class);
		final DatabaseManager databaseManager = context
				.mock(DatabaseManager.class);

		LoginAction loginAction = new LoginAction();
		loginAction.setDatabaseConnection(databaseConnection);
		loginAction.setDatabaseManager(databaseManager);

		context.checking(new Expectations() {
			{
				oneOf(databaseConnection).isConnectioned();
				will(returnValue(false));
			}
		});

		loginAction.login("root", "root");

		context.assertIsSatisfied();
	}
}