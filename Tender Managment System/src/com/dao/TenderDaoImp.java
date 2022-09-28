package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Exception.TendorException;
import com.Exception.VenderException;
import com.bean.Tender;
import com.bean.Vender;
import com.utility.DButil;

public class TenderDaoImp implements TenderDao {

	@Override
	public String registerVender(Vender vender) {
		
		String message ="Vender Not Added";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("insert into vender(vname, vemail,vpassword) values(?,?,?)");
			
			ps.setString(1, vender.getVenderName());
			ps.setString(2, vender.getVenderEmail());
			ps.setString(3, vender.getvPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Vender Register Sucessfull";
			}
			
			
			
		} catch (Exception e) {
			 message = e.getMessage();
		}
		
		
		
		
		return message;
		
	}

	@Override
	public ArrayList<Vender> showVender() throws VenderException {
		ArrayList<Vender> list = new ArrayList<>();
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from vender");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("vid");
				String name = rs.getString("vname");
				String email = rs.getString("vemail");
				String passWord = rs.getString("vpassword");
				
				list.add(new Vender(id, name, email, passWord));
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new VenderException(e.getMessage());
			
		}
		if(list.size()==0) {
			throw new VenderException("No Vender Found Register A vender First!!!!");
		}
		
		
		
		return list;
	}

	@Override
	public String addTender(Tender tender) {
	  String message = "Tender Not Added";
	  
	  try (Connection conn = DButil.provideConnection()){
		  
		  PreparedStatement ps = conn.prepareStatement("insert into tender(tname, tamount) values(?,?)");
		  
		  ps.setString(1, tender.getCategory());
		  ps.setInt(2, tender.getAmmount());
		  
		  
		  int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Tender Register Sucessfull";
			}
		  
		
		} catch (Exception e) {
			message = e.getMessage();
		}
	  
	  
	  
	  
	  
		return message;
	}

	@Override
	public ArrayList<Tender> showTender() throws TendorException {
		
		ArrayList<Tender> tlist = new ArrayList<>();
		
		try(Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("Select * from tender");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int  id = rs.getInt("tid");
				String name = rs.getString("tname");
				int amount = rs.getInt("tamount");
				
				tlist.add(new Tender(id, name, amount));
				
				
				
				
			}
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new TendorException(e.getMessage());
		}
		
		if(tlist.size()==0) {
			throw new TendorException("No Tendor Found This Time Please Add to See the Tender");
		}
		
		
		
		return tlist;
	}
	
	
	
	
	
	

}
