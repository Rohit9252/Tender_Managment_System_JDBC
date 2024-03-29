package com.ClientUsage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Exception.TendorException;
import com.Exception.VenderException;
import com.bean.TenderStatus;
import com.dao.TenderDaoImp;

public class VenderWroking {
	
	public static boolean  showChoiceToVender() {
//		VenderRegister v = new VenderRegister();
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.println("Hi! Welcome back. Here are some Option");
			System.out.println("1. See All Latest Tender");
			System.out.println("2. Apply for a Tender");
			System.out.println("3. Get Status Of Tender");
			System.out.println("4. Get History Of all Your Bid");
			System.out.println("5.Do You Want Exit(Y/N)");
			
			int opt = sc.nextInt();
			
			boolean flag = true;
			
			switch (opt) {
			
			case 1: VenderRegister.showAllTender();
			
			break;
			
			case 2:
				applyBidForTender();
				;
				break;
				
			case 3:
				statusOfTender();
				break;
				
			case 4:
				getHistory();
				break;
				
			case 5:  System.out.println("Do You Want To LogOut! Please Type (Y/N)");
			String ans =	sc.next();
			if(ans.equalsIgnoreCase("Y")) return false;
			break;
			
			default:
				System.out.println("You Enter a Wrong Info");
				break;
				
			}
		}
		
		
		
		
	}
	
	
	
	public static void applyBidForTender() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Your Vender  Id Is");
		int venderId =sc.nextInt();
		System.out.println("Enter The Tender Specif Id");
		int tenderid = sc.nextInt();
		
		System.out.println("Enter Your Bid Amount ");
		int amount = sc.nextInt();
		
		
		TenderDaoImp dao = new TenderDaoImp();
		try {
			String msg = dao.addBidForTender(venderId, tenderid, amount);
			
			System.out.println(msg);
			
			
		} catch (TendorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	public static void statusOfTender() {
		
		Scanner sc = new Scanner(System.in);
		TenderDaoImp dao = new TenderDaoImp();
		
		
		
		System.out.println("Enter the Vender Id");
		int venderId =sc.nextInt();
		
		
		System.out.println("Eneter the Tender Id");
		int  tenderId= sc.nextInt();
		
		 try {
			List<TenderStatus>  arr =  dao.statusOftenderBid(venderId, tenderId);
			
			arr.forEach(v->{
				
				System.out.println("Vender Id is "+v.getVenderiId());
				System.out.println("Vender Name is "+v.getVenderName());
				System.out.println("Tender Id is "+v.getTenderId());
				System.out.println("Tender Name is " +v.getTenderName());
				System.out.println("Tender Amount is "+v.getTenderAmount());
				System.out.println("Tender Status is " +v.getStatusBid());
				
				
				System.out.println("----------------------------------");
				
				
			});
			
			
			
			
		} catch (TendorException e) {
			System.out.println(e.getMessage());
		}
		

	}


	public static void getHistory() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Please Enter Your Vender ID  to Check The History of Bid against Tender ");
		
		int tenderId = sc.nextInt();
		
		TenderDaoImp dao = new TenderDaoImp();
		
				try {
				List<TenderStatus> arr =	dao.HistoryOfTender(tenderId);
				
				arr.forEach(v->{
					
					System.out.println("Vender Id is "+v.getTenderId());
					System.out.println("Vender Name is "+v.getVenderName());
					System.out.println("Tender Id is "+v.getTenderId());
					System.out.println("Tender Name is " +v.getTenderName());
					System.out.println("Tender Amount is "+v.getTenderAmount());
					System.out.println("Tender Status is " +v.getStatusBid());
					
					
					System.out.println("----------------------------------");
					
					
				});
					
					
					
				} catch (VenderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
		
	}

	
	
	
	

}
