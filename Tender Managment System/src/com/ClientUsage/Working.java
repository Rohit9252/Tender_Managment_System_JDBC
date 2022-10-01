package com.ClientUsage;

import java.util.Scanner;

public class Working {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

	public static int count = 0;

	public static void showChoice() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Your Choice");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Vender");
		System.out.println("3. Exit");
		int opt = sc.nextInt();
		boolean ans = true;
		while (ans) {
			if (opt == 1) {
				boolean flag = true;
				while (flag) {
					System.out.println("Enter your User NameName ");
					String name = sc.next();
					System.out.println("Enter uour password Password");
					String password = sc.next();

					if (name.equals("admin") && password.equals("admin@123")) {
						boolean a =Working.adminstration();
						if(!a) {
							ans= false;
							
							System.out.println("Thank You Come Back Soon!!!");
							return;
						}
						flag = false;

					} else {
						count++;
						System.out.println("You have enter wrong Detail");

						if (count >= 3) {
							System.out.println(ANSI_RED_BACKGROUND
									+ "You have Enter too many Attempts! Try again after Some time" + ANSI_RESET);
							return;
						}
					}
				}

			}

			if (opt == 2) {
				VenderRegister v = new VenderRegister();
				boolean flag = v.loginVender();

				if (flag) {
					boolean a=vender();
					
					if(!a) {
						ans= false;
						
						System.out.println("Thank You Come Back Soon!!!");
						return;
					}
					

				} else {

					System.out.println("Please Try Agin after Some time");

				}
			}

			if (opt == 3) {
				System.out.println("Thank You Come Back Soon!!!");
				return;
			}

		}

	}

	public static boolean adminstration() {

		VenderRegister vr = new VenderRegister();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi! Welcome back. Here are some Option");
		boolean flag = true;
		while(flag) {
		System.out.println("1. Register a Vender");
		System.out.println("2. See All Vender");
		System.out.println("3. Create A Tender");
		System.out.println("4. View All the Tenders");
		System.out.println("5. Assign the Tender to vender");
		System.out.println("6. For Log out");

		int opt = sc.nextInt();

		



		switch (opt) {

		case 1:
			vr.register();
			break;

		case 2:
			vr.showVender();
			;
			break;

		case 3:
			vr.addtoTendor();
			break;

		case 4:
			vr.showAllTender();
			break;

		case 5:
			vr.assignTender();
			;
			break;

		case 6:  flag = false;
		break;


		default:
			System.out.println("You Enter a Wrong Info");
			break;

		}
	}

//		sc.close();
  return flag;
}

	public static boolean vender() {

		VenderWroking v = new VenderWroking();
		boolean ans = v.showChoiceToVender();
		return ans;

	}

}
