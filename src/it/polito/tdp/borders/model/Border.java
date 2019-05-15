package it.polito.tdp.borders.model;

public class Border {

	private int cod1;
	private int cod2;
	
	public Border(int uno, int due) {
		super();
		this.cod1 = uno;
		this.cod2 = due;
	}

	public int getCod1() {
		return cod1;
	}

	public void setCod1(int cod1) {
		this.cod1 = cod1;
	}

	public int getCod2() {
		return cod2;
	}

	public void setCod2(int cod2) {
		this.cod2 = cod2;
	}
	
}
