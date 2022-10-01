package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.Exception.TendorException;
import com.Exception.VenderException;
import com.bean.Tender;
import com.bean.TenderBid;
import com.bean.TenderStatus;
import com.bean.Vender;

public interface TenderDao {
	
	public String registerVender(Vender vender);
	
	public ArrayList<Vender> showVender() throws VenderException;
	
	
	public String addTender(Tender tender); 
	
	
	public ArrayList<Tender> showTender() throws TendorException;
	
	
	public Vender loginVender(String userName, String password) throws VenderException;
	
	
	public String addBidForTender(int vdenderId, int tenderId, int amount) throws TendorException; 
	
	public List<TenderStatus> statusOftenderBid(int venderId, int tenderid) throws TendorException;
	
	public List<TenderStatus> HistoryOfTender(int venderId) throws VenderException;
	
	public List<TenderBid> showTenderBid();
	
	public List<TenderBid> showMinTenderBid() throws TendorException;
	
	public List<TenderBid> showMinStatusTenderBid(int ans) throws TendorException;
	
	public String assignTender(int bid, int btid) throws TendorException;
	
	
	
	
}
