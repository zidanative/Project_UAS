package uas.views;

import java.util.Scanner;

import uas.dao.PegawaiDAO;
import uas.daoimpl.PegawaiDAOImpl;

public class PegawaiView {
	
	public PegawaiView() {
		
	}
	
	
	// bakal dihapus
	
	
	
	
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
	        	FormView.insertPegawai();
	        	break;
	        case 2:
	        	FormView.searchPegawaiByEmail();
	        	break;
	        case 3:
	        	PegawaiMisc.displayTabelPegawai(operation.getAllPegawai());
	        	break;
	        case 4:
	        	FormView.updatePegawai();
	        	break;
	        case 5:
	        	FormView.deletePegawai();
	        	break;
	        default:
	        	System.out.println("Warning: Pilihan yang anda masukkan salah!");  	
        }
        
        scanner.close();
	}
}
