package ziji.unit_mock;

public class LoginAction {
	DatabaseConnection databaseConnection;
	DatabaseManager databaseManager;

	public void setDatabaseConnection(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public String login(String username, String password)
			throws DatabaseConnException {

		if (!databaseConnection.isConnectioned()) {
			throw new DatabaseConnException("database connection error");
		}

		boolean isExistAccount = databaseManager.isExistAccount(username, password);
		if (true == isExistAccount) {
			return "login successed";
		}

		return "login failed";
	}
}