package it.polito.tdp.borders.model;

public class Country {
	
	private int cod;
	private String name;
	private String stateAbb;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStateAbb() {
		return stateAbb;
	}
	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}
	
	public Country(int cod, String name, String stateAbb) {
		super();
		this.cod = cod;
		this.name = name;
		this.stateAbb = stateAbb;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (cod != other.cod)
			return false;
		return true;
	}
	
}
