package ziji.json;

import java.util.List;

public class Top {
	
	private String topname;
	
	private Bottom bottom;
	
	private List<Bottom> bottoms;

	/**
	 * @return the topname
	 */
	public String getTopname() {
		return topname;
	}

	/**
	 * @param topname the topname to set
	 */
	public void setTopname(String topname) {
		this.topname = topname;
	}

	/**
	 * @return the bottom
	 */
	public Bottom getBottom() {
		return bottom;
	}

	/**
	 * @param bottom the bottom to set
	 */
	public void setBottom(Bottom bottom) {
		this.bottom = bottom;
	}

	/**
	 * @return the bottoms
	 */
	public List<Bottom> getBottoms() {
		return bottoms;
	}

	/**
	 * @param bottoms the bottoms to set
	 */
	public void setBottoms(List<Bottom> bottoms) {
		this.bottoms = bottoms;
	}
	
	
}
