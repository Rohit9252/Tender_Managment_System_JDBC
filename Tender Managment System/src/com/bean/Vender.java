package com.bean;

public class Vender {
	
	private int venderId;
	private String venderName;
	private  String  venderEmail;
	private  String  vPassword;
	
	
	public Vender() {
		// TODO Auto-generated constructor stub
	}


	public Vender(String venderName, String venderEmail, String vPassword) {
		super();
		this.venderName = venderName;
		this.venderEmail = venderEmail;
		this.vPassword = vPassword;
	}


	public Vender(int venderId, String venderName, String venderEmail, String vPassword) {
		super();
		this.venderId = venderId;
		this.venderName = venderName;
		this.venderEmail = venderEmail;
		this.vPassword = vPassword;
	}


	@Override
	public String toString() {
		return "Vender [venderId=" + venderId + ", venderName=" + venderName + ", venderEmail=" + venderEmail
				+ ", vPassword=" + vPassword + "]";
	}


	public int getVenderId() {
		return venderId;
	}


	public void setVenderId(int venderId) {
		this.venderId = venderId;
	}


	public String getVenderName() {
		return venderName;
	}


	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}


	public String getVenderEmail() {
		return venderEmail;
	}


	public void setVenderEmail(String venderEmail) {
		this.venderEmail = venderEmail;
	}


	public String getvPassword() {
		return vPassword;
	}


	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}
	
	
	
	
	
	

}
