package uas.daoimpl;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itenas.oop.jdbc.dao.PegawaiDAO;

import uas.bean.Pegawai;
import uas.utils.DatabaseUtil;
import uas.views.TableView;

public class PegawaiDAOImpl implements PegawaiDAO {

	@Override
	public Pegawai getPegawaiById(int id) {
		return null;
	}

	@Override
	public Pegawai getPegawaiByNama(String nama) {
		return null;
	}

	@Override
	public void getPegawaiByEmail(String email) {
		DatabaseUtil db = new DatabaseUtil();
		Pegawai pegawai = new Pegawai();
		try {
			db.connect();
 
            String query = "SELECT * FROM pegawai WHERE email = '"+email+"'";
            ResultSet rs = db.readData(query);
 
            // process query results
            if (rs.next()) {
 
                ResultSetMetaData metaData = rs.getMetaData();
                int jumlahKolom = metaData.getColumnCount();
                do {
                    for (int i = 1; i <= jumlahKolom; i++) {
                    	pegawai.setId(Integer.parseInt(rs.getObject(1).toString()));
                    	pegawai.setNama(rs.getObject(2).toString());
                        pegawai.setEmail(rs.getObject(3).toString());
                        pegawai.setPosition(rs.getObject(4).toString());
                        pegawai.setAlamat(rs.getObject(5).toString());
                        pegawai.setNohp(rs.getObject(6).toString());
                    }
                } while (rs.next());
                
            } else {
            	pegawai.setId(0);
            }

            db.disconnect();            
 
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
		
		TableView.displayTuplePegawai(pegawai);
	}

	@Override
	public String getNamaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Pegawai> getAllPegawai() {
		List<Pegawai> listPegawai = new ArrayList<Pegawai>();
		DatabaseUtil db = new DatabaseUtil();
		try {
			db.connect();
			 
            String query = "SELECT * FROM pegawai";
         
            ResultSet rs = db.readData(query);
 
            // process query results
            while (rs.next()) {
 
        		Pegawai pegawai = new Pegawai();
            	
        		pegawai.setId(Integer.parseInt(rs.getObject(1).toString()));
            	pegawai.setNama(rs.getObject(2).toString());
                pegawai.setEmail(rs.getObject(3).toString());
                pegawai.setPosition(rs.getObject(4).toString());
                pegawai.setAlamat(rs.getObject(5).toString());
                pegawai.setNohp(rs.getObject(6).toString());
                
                listPegawai.add(pegawai);
 
            } 
            db.disconnect();
			
		} catch (SQLException ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
		
		return listPegawai;
	}

	@Override
	public void updatePegawai(Pegawai pegawai) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "UPDATE pegawai SET nama='"+pegawai.getNama()+"',"
					+ " email='"+pegawai.getEmail()+"',"
					+ " position+'"+pegawai.getPosition()+"',"
					+ " alamat="+pegawai.getAlamat()+"',"
					+ " no hp="+pegawai.getNohp()+"',"
					+ " WHERE nip='"+pegawai.getId()+"'";
			
			db.executeQuery(query);
			System.out.println("Data berhasil diperbarui!");
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
		
	}

	@Override
	public void deletePegawai(Pegawai pegawai) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "DELETE FROM pegawai WHERE id='"+pegawai.getId()+"'";
			db.executeQuery(query);
			TableView.displayTabelPegawai(getAllPegawai());
		} catch (Exception e) {
			System.out.println("Terjadi error: " + e.getMessage());
		}
	}

	@Override
	public void savePegawai(Pegawai pegawai) {
		DatabaseUtil db = new DatabaseUtil();
		String query;
		try {
			db.connect();
			query = "INSERT INTO pegawai (id, nama, email, position, no_hp, alamat)"
					+ " VALUES ("+pegawai.getId()+", '"
					+ pegawai.getNama()+"', '"
					+ pegawai.getEmail()+"', '"
					+ pegawai.getPosition()+"', '"
					+ pegawai.getNohp()+"', '"
					+ pegawai.getAlamat()+"')";
			
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan!");
		} catch (Exception ex) {
			System.out.println("Terjadi error: " + ex.getMessage());
		}
	}

}
