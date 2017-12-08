package kr.ac.hansung.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SI {
	private String division;
	private int credit;
	public void setCredit(int int1) {
		this.credit = int1;
	}
	public void setDivision(String string) {
		this.division = string;
	}
}
