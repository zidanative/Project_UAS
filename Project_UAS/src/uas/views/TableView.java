package uas.views;

import java.util.List;
import java.util.Scanner;

import org.itenas.oop.jdbc.dao.PegawaiDAO;

import uas.bean.Pegawai;
import uas.daoimpl.PegawaiDAOImpl;

public class TableView {
	public static void main(String[] args) {
		PegawaiDAO operation = new PegawaiDAOImpl();
		displayTabelPegawai(operation.getAllPegawai());
	}
	
	public static void displayTabelPegawai(List<Pegawai> listPegawai) {
		char back;
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.println("    |						DATA Pegawai						    |");
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.println("    |\tID\t|\tNama\t\t\t|       Email       		|         Posisi   	    |");
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		for (Pegawai dPegawai : listPegawai) {
			System.out.println("    |\t"+dPegawai.getId()+"\t|       "+dPegawai.getNama()+"\t        |       "+dPegawai.getEmail()+"\t|\t    "+dPegawai.getPosition()+"\t\t    |");
		}
		System.out.println("     -------------------------------------------------------------------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			PegawaiView.displayMenuPegawai();
		}
	}
	
	public static void displayTuplePegawai(Pegawai pegawai) {
		char back;
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.println("     -----------------------------------------------------------");
		System.out.println("    |		DATA Pegawai					|");
		System.out.println("     -----------------------------------------------------------");
		System.out.println("    |NIP\t\t: " + pegawai.getId()+"\t\t\t\t\t|");
		System.out.println("    |Nama\t\t: " + pegawai.getNama()+"\t\t\t\t|");
		System.out.println("    |Email\t\t: " + pegawai.getEmail()+"\t\t|");
		System.out.println("    |Posisi    \t\t: " + pegawai.getPosition()+"\t\t|");
		System.out.println("     -----------------------------------------------------------");
		System.out.print("    | [B] Tekan Tombol B untuk kembali ke menu sebelumnya: ");
		back = in.next().charAt(0);
		if (back == 'B' || back == 'b') {
			PegawaiView.displayMenuPegawai();
		}
	}
}
