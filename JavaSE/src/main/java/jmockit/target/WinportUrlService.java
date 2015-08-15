package jmockit.target;

public interface WinportUrlService {
	boolean hasWinport(String memberId);

	String getWinportUrlThrowException(String memberId);
}