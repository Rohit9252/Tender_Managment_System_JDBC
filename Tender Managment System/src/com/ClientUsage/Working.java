package com.ClientUsage;

import java.util.Scanner;

public class Working {
	
	public static int count=0;
	
	public static void showChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Choice");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Vender");
		int opt = sc.nextInt();
		
		if(opt==1) {
			boolean flag = true;
			while(flag) {
				System.out.println("Enter The Name ");
				String name = sc.next();
				System.out.println("Enter the Password");
				String password = sc.next();
				
				if(name.equals("admin")&&password.equals("admin@123")) {
					
					Working.adminstration();
					flag = false;
					
				}else {
					count++;
					System.out.println("You have enter wrong Detail");
					
					if(count>=3) {
						System.out.println("You have Enter too many Attempts! Try again after some time");
						return;
					}
				}
			}
			
			
		}else {
			vender();
		}
		
	}
	
	
	public static void adminstration() {
		
		VenderRegister vr = new VenderRegister();
		Scanner  sc= new Scanner(System.in);
		System.out.println("Hi! Welcome back. Here are some Option");
		System.out.println("1. Register a Vender");
		System.out.println("2. See All Vender");
		System.out.println("3. Create A Tender");
		System.out.println("4. View All the Tenders");
		System.out.println("Assign the Tender to vender");
		
		int opt= sc.nextInt();
		
		boolean flag = true;
		
		
		switch(opt) {
		
		case 1: vr.register();
				break;
		
		case 2:vr.showVender();;
		break;
		
		case 3: vr.addtoTendor();
		break;
		
		case 4: System.out.println("you selected view All Tender");
		break;
		
		case 5: System.out.println("you selected Assign a tender to vender");
		break;
		
	 }
		
		
		
		
		
		
		
		
	}
	public static void vender() {
		System.out.println("Hello to vender panel");
		
		
		
		
		
		
	}
	

}