package Main;

import com.ClientUsage.Working;

public class Main {
	
	public static final String ANSI_RESET = "\u001B[0m";
	  
    // Declaring the color
    // Custom declaration
    public static final String ANSI_BLUE = "\u001B[34m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ANSI_BLUE+"Welcome to Online  Tender Management "+ANSI_RESET);
		 Working work = new Working();
		 work.showChoice();
		 
		
		
	}

}
