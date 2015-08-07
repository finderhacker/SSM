package ziji.unit_mock;

public class Logic4 {

	static class SpecialException extends Exception {
		private static final long serialVersionUID = 1L;

		public SpecialException() {
		}

		public SpecialException(String msg) {
			super(msg);
		}
	}

	public void testException(boolean isTriggerException)
			throws SpecialException {
		if (isTriggerException) {
			throw new SpecialException("This is a exception for junit test!");
		} else {
			// do nothing...
		}

	}

}