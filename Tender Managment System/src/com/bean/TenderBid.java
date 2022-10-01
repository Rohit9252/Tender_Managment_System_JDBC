package com.bean;

public class TenderBid {

	private int bid;
	private int btid;
	private int amount;
	private String status;

	public TenderBid(int bid, int btid, int amount, String status) {
		super();
		this.bid = bid;
		this.btid = btid;
		this.amount = amount;
		this.status = status;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBtid() {
		return btid;
	}

	public void setBtid(int btid) {
		this.btid = btid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TenderBid [bid=" + bid + ", btid=" + btid + ", amount=" + amount + ", status=" + status + "]";
	}

	public TenderBid() {
		super();
	}

}
