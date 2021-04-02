package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Mahasiswa;
import com.example.demo.model.Nilai;

public class MatkulDto {
	
	private int id;
	private String nama_matkul;
	private String idmaha;
	
	private Mahasiswa mahasiswa;
	private List<Nilai> nilai;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama_matkul() {
		return nama_matkul;
	}
	public void setNama_matkul(String nama_matkul) {
		this.nama_matkul = nama_matkul;
	}
	public String getidmaha() {
		return idmaha;
	}
	public void setid_maha(String idmaha) {
		this.idmaha = idmaha;
	}
	public Mahasiswa getMahasiswa() {
		return mahasiswa;
	}
	public void setMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
	}
	public List<Nilai> getNilai() {
		return nilai;
	}
	public void setNilai(List<Nilai> nilai) {
		this.nilai = nilai;
	}
	public MatkulDto(int id, String nama_matkul, String idmaha, Mahasiswa mahasiswa, List<Nilai> nilai) {
		super();
		this.id = id;
		this.nama_matkul = nama_matkul;
		this.idmaha = idmaha;
		this.mahasiswa = mahasiswa;
		this.nilai = nilai;
	}
	public MatkulDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
