package jmockit.target;

public class OfferPostAction {

	private WinportUrlServiceImpl winportUrlService = new WinportUrlServiceImpl();

	public boolean hasWinport(String memberId) {
		return winportUrlService.hasWinport(memberId);
	}
	
	public String getWinportUrlThrowException(String memberId){
		return winportUrlService.getWinportUrlThrowException(memberId);
	}
	
	public long getPostedOfferCounts(String memberId){  //base中
		return winportUrlService.getPostedOfferCounts(memberId);
	}
}