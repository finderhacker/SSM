package spe.spring3.test.in;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class B {

	private List list;

	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}
}
