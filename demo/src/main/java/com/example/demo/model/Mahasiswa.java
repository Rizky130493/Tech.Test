package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "alamat")
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

	public Mahasiswa(int id, String nama, String alamat) {
		super();
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
	}

	public Mahasiswa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//RELASI
//	@OneToMany (fetch = FetchType.LAZY , mappedBy= "mahasiswa")
//	private List<Matkul> matkul;
//
//
//	public List<Matkul> getMatkul() {
//		return matkul;
//	}
//
//	public void setMatkul(List<Matkul> matkul) {
//		this.matkul = matkul;
//	}
	
	
	
	

	

}
