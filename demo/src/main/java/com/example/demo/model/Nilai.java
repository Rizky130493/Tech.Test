package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nilai")
public class Nilai {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "idmaha")
	private long idmaha;
	
	@Column(name = "idmatkul")
	private long idmatkul;
	
	@Column(name = "nilai")
	private String nilai;
	
	@Column(name = "keterangan")
	private String keterangan;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdmaha() {
		return idmaha;
	}

	public void setIdmaha(long idmaha) {
		this.idmaha = idmaha;
	}

	public long getIdmatkul() {
		return idmatkul;
	}

	public void setIdmatkul(long idmatkul) {
		this.idmatkul = idmatkul;
	}

	public String getNilai() {
		return nilai;
	}

	public void setNilai(String nilai) {
		this.nilai = nilai;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	

	public Nilai(long idmaha, long idmatkul, String nilai, String keterangan, Mahasiswa mahasiswa, Matkul matkul) {
		super();
		this.idmaha = idmaha;
		this.idmatkul = idmatkul;
		this.nilai = nilai;
		this.keterangan = keterangan;
		this.mahasiswa = mahasiswa;
		this.matkul = matkul;
	}

	public Nilai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
//RELASI
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmaha",  insertable=false, updatable=false)
	@JsonIgnore
	private Mahasiswa mahasiswa;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmatkul",  insertable=false, updatable=false)
	@JsonIgnore
	private Matkul matkul;

	public Mahasiswa getMahasiswa() {
		return mahasiswa;
	}

	public void setMahasiswa(Mahasiswa mahasiswa) {
		this.mahasiswa = mahasiswa;
	}

	public Matkul getMatkul() {
		return matkul;
	}

	public void setMatkul(Matkul matkul) {
		this.matkul = matkul;
	}
	

	
	
	

	
}
