package org.itenas.oop.jdbc.dao;

import java.util.List;

import uas.bean.Pegawai;

public interface PegawaiDAO {
    public Pegawai getPegawaiById(int id);
    public Pegawai getPegawaiByNama(String nama);
    public void getPegawaiByEmail(String email);
    public String getNamaById(int id);
    
    public List<Pegawai> getAllPegawai();
    public void savePegawai(Pegawai pegawai);
    public void updatePegawai(Pegawai pegawai);
    public void deletePegawai(Pegawai pegawai);
}
