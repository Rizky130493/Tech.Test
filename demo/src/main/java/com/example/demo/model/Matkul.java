package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matkul")
public class Matkul {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nama_matkul")
	private String nama_matkul;
	
	@Column(name = "idmaha")
	private long idmaha;

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

	public long getIdmaha() {
		return idmaha;
	}

	public void setIdmaha(long idmaha) {
		this.idmaha = idmaha;
	}

	public Matkul(int id, String nama_matkul, long idmaha) {
		super();
		this.id = id;
		this.nama_matkul = nama_matkul;
		this.idmaha = idmaha;
	}

	public Matkul() {
		super();
		// TODO Auto-generated constructor stub
	}
}
