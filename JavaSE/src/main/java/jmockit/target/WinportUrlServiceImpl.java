package jmockit.target;

public class WinportUrlServiceImpl extends WinportBaseService implements
		WinportUrlService {
	public boolean hasWinport(String memberId) {
		return true;
	}

	public String getWinportUrlThrowException(String memberId) {
		throw new RuntimeException();
	}
}