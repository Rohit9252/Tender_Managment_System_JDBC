package com.ClientUsage;

import java.util.ArrayList;
import java.util.Scanner;

import com.Exception.TendorException;
import com.Exception.VenderException;
import com.bean.Tender;
import com.bean.Vender;
import com.dao.TenderDaoImp;

public class VenderRegister  {
	
	public static void register() {
		Scanner sc = new Scanner(System.in);
		
		  System.out.println("Enter Vender Name");
		  String name = sc.next();
		  
		  System.out.println("Enter User Email Address");
		  String email = sc.next();
		  System.out.println("Enter the Password");
		 String password = sc.next();
		 
		 
		 TenderDaoImp tdi = new TenderDaoImp();
		  String msg =tdi.registerVender(new Vender(name, email, password));
		  System.out.println(msg);
		  
//		  sc.close();
	}
	
	public static void  showVender() {
		
		TenderDaoImp tdi = new TenderDaoImp();
		
		try {
			ArrayList<Vender> list =   tdi.showVender();
			
			list.forEach(v->{
				System.out.println("Vender Id is"+v.getVenderId());
				System.out.println("Vender Name is "+v.getVenderName());
				System.out.println("vender email is "+v.getVenderEmail());
				System.out.println("Vender Passwod is "+v.getvPassword());
				System.out.println("----------------------------------");
				
				
			});
		} catch (VenderException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static  void addtoTendor() {
		
		TenderDaoImp tdi = new TenderDaoImp();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Tender name");
		
		String name = sc.next();
		
		System.out.println("Enter The tender Base Amount");
		
		int price = sc.nextInt();
		
		String msg = tdi.addTender(new Tender(name, price));
		
		
		System.out.println(msg);
		
//		sc.close();
		
	}
	
	public static void showAllTender() {
		
		
		TenderDaoImp tdi = new TenderDaoImp();
		
		 try {
			ArrayList<Tender> tlist =    tdi.showTender();
			
			tlist.forEach(t->{
				
				System.out.println("Tender ID is  "+ t.getTenderId());
				System.out.println("Tender Name is "+t.getCategory());
				System.out.println("Tender Amount  "+t.getAmmount());
				
				System.out.println("-------------------------------");
				
			});
			
			
		} catch (TendorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		 
			
	}
	
	public static boolean  loginVender() {
		
		boolean flag = true;
		
		TenderDaoImp tdi = new TenderDaoImp();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username  for Login");
		
		
		String name = sc.next();
		
		System.out.println("Enter The Password");
		
		String password = sc.next();
		
		
		
		try {
			Vender v = tdi.loginVender(name, password);
		
			if(v!=null) {
				flag = true;
				System.out.println("Welcome Mr. "+v.getVenderName()+"  Have a nice day");
				
			
			}else {
				flag = false;
				
				
			}
	
			
			
		} catch (VenderException e) {
			// TODO Auto-generated catch block
		  System.out.println(e.getMessage());
		  
		}
		
		
		return flag;
		
//		sc.close();
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
