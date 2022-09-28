package com.bean;

public class Tender {
	private int tenderId;
	private String category;
	private int ammount;

	public Tender() {
		// TODO Auto-generated constructor stub
	}

	public Tender(int tenderId, String category, int ammount) {
		super();
		this.tenderId = tenderId;
		this.category = category;
		this.ammount = ammount;
	}

	public Tender(String category, int ammount) {
		super();
		this.category = category;
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "Tender [tenderId=" + tenderId + ", category=" + category + ", ammount=" + ammount + "]";
	}

	public int getTenderId() {
		return tenderId;
	}

	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

}
