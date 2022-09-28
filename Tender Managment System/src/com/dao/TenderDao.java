package com.dao;

import java.util.ArrayList;

import com.Exception.TendorException;
import com.Exception.VenderException;
import com.bean.Tender;
import com.bean.Vender;

public interface TenderDao {
	
	public String registerVender(Vender vender);
	
	public ArrayList<Vender> showVender() throws VenderException;
	
	
	public String addTender(Tender tender); 
	
	
	public ArrayList<Tender> showTender() throws TendorException;
	
	
}
