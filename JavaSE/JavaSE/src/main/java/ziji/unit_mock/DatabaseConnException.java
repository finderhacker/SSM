package ziji.unit_mock;

public class DatabaseConnException extends Exception {
	private static final long serialVersionUID = 1L;

	public DatabaseConnException() {
	}

	public DatabaseConnException(String message) {
		super(message);
	}
}