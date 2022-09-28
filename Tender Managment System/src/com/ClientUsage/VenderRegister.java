package com.ClientUsage;

import java.util.ArrayList;
import java.util.Scanner;

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
			e.printStackTrace();
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
		
		
		
	}
	
	

}
