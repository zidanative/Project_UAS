package uas.views;

import java.util.Scanner;

import org.itenas.oop.jdbc.dao.PegawaiDAO;

import uas.bean.Pegawai;
import uas.daoimpl.PegawaiDAOImpl;

public class FormView {
	public static void formInsertPegawai() {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		char back;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Insert Data Pegawai	          |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | ID			:");
        pegawai.setId(scanner.nextInt());
        System.out.print("              | Nama		        :");
        pegawai.setNama(scanner2.nextLine());
        System.out.print("              | Email                   :");
        pegawai.setEmail(scanner2.nextLine());
        System.out.print("              | Posisi				  :");
        pegawai.setPosition(scanner2.nextLine());
        System.out.print("              | NO HP					  :");
        pegawai.setNohp(scanner2.nextLine());
        System.out.print("              | Alamat	        	  :");
        pegawai.setAlamat(scanner2.nextLine());
        System.out.println("              *****************************************					 ");
        operation.savePegawai(pegawai);
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = scanner2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			PegawaiView.displayMenuPegawai();
		}
	}
	
	public static void formUpdatePegawai() {
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		int id;
		char back;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.print("Masukkan NIP dari data yang akan diupdate: ");
		id = in.nextInt();
		System.out.println();
		System.out.println("              *****************************************                  ");
        System.out.println("              | Form Update Data Karyawan Tetap        |                  ");
        System.out.println("              *****************************************                  ");
        System.out.print("              | NIP			:");
        System.out.println(id);
        pegawai.setId(id);
        System.out.print("              | Nama		        :");
        pegawai.setNama(in2.nextLine());
        System.out.print("              | Email                   :");
        pegawai.setEmail(in2.nextLine());
        System.out.print("              | Posisi				  :");
        pegawai.setPosition(in2.nextLine());
        System.out.print("              | NO HP					  :");
        pegawai.setNohp(in2.nextLine());
        System.out.print("              | Alamat	        	  :");
        pegawai.setAlamat(in2.nextLine());
        System.out.println("              *****************************************					 ");
        operation.updatePegawai(pegawai);;
        System.out.print("[B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in2.next().charAt(0);
		if (back == 'B' || back == 'b') {
			PegawaiView.displayMenuPegawai();
		}
	}
	
	public static void formDeletePegawai() {
		Scanner in = new Scanner(System.in);
		int id;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.print("Masukkan NIP dari data yang akan dihapus: ");
		id = in.nextInt();
		pegawai.setId(id);
		operation.deletePegawai(pegawai);	
	}
	
	public static void formSearchPegawaiByEmail() {
		Scanner in = new Scanner(System.in);
		String email;
		Pegawai pegawai = new Pegawai();
		PegawaiDAO operation = new PegawaiDAOImpl();
		System.out.print("Masukkan email dari data yang akan dicari: ");
		email = in.nextLine();
		pegawai.setEmail(email);
		operation.getPegawaiByEmail(email);	
	}
}
