package uas.views;

import java.util.Scanner;

import org.itenas.oop.jdbc.dao.PegawaiDAO;

import uas.daoimpl.PegawaiDAOImpl;

public class PegawaiView {
	
	public PegawaiView() {
		
	}
	
	public static void displayMenuPegawai() {
		int menu;
		Scanner scanner = new Scanner(System.in);
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.println();			        
        System.out.println("              *****************************************                  ");
        System.out.println("              |            Data Karyawan Tetap        |                  ");
        System.out.println("              *****************************************                  ");
        System.out.println("              | Pilihan:                              |                  ");
        System.out.println("              |        1. Input Data		      |  				 ");
        System.out.println("              |        2. Cari Data By Email          |                  ");
        System.out.println("              |        3. Tampilkan Seluruh Data      |                  ");
        System.out.println("              |        4. Perbarui Data               |                  ");
        System.out.println("              |        5. Hapus Data                  |                  ");
        System.out.println("              |        6. Kembali                     |                  ");
        System.out.println("              *****************************************                  ");	
        System.out.println();
        System.out.print("Pilih menu: ");
        menu = scanner.nextInt();
        
        while (!(menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5 || menu == 6)) {
        	System.out.println("Warning: Menu yang Anda masukkan salah!");
        	System.out.print("Silahkan pilih menu kembali: ");
        	menu = scanner.nextInt();
        }
        
        switch (menu) {
	        case 1:
	        	FormView.formInsertPegawai();
	        	break;
	        case 2:
	        	FormView.formSearchPegawaiByEmail();
	        	break;
	        case 3:
	        	TableView.displayTabelPegawai(operation.getAllPegawai());
	        	break;
	        case 4:
	        	FormView.formUpdatePegawai();
	        	break;
	        case 5:
	        	FormView.formDeletePegawai();
	        	break;
	        case 6:
	        	MenuUtamaView.mainMenu();
	        	break;
	        default:
	        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
        }
        
        scanner.close();
	}
}
