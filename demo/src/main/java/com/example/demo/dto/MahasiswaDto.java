package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Matkul;

public class MahasiswaDto {
	
	private int id;
	private String nama;
	private String alamat;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}


	public MahasiswaDto(int id, String nama, String alamat) {
		super();
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
	}

	public MahasiswaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
