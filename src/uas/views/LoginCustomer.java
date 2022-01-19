package uas.views;

import java.util.Scanner;

public class LoginCustomer {
	public static void profileMenu() {
		int menu;
		Scanner scanner = new Scanner(System.in);
		boolean left = false;
        do {
        	System.out.println("1. Check In Kamar\n"
    				+ "2. Check Out\n"
    				+ "3. Perbarui Profil\n"
    				+ "3. Log Out");
		    System.out.print("Pilih menu: ");
		    menu = scanner.nextInt();
		    switch (menu) {
		        case 1:
		        	FormView.updatePegawai();
		        	FormView.insertPegawai();
		        	break;
		        case 2:
		        	CustomerSettings.updateCustomer();
		        	FormView.viewProfileCustomer();
		        	break;
		        case 3:
		        	IndexCustomer.inId = 0;
		        	IndexCustomer.inNama = null;
		        	Driver.main(null);
		        	break;
		        default:
		        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
		    }
        } while(!left);
        
        scanner.close();
	}
}