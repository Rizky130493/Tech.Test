package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.NilaiDto;
import com.example.demo.model.Nilai;

@Service
public class NilaiService {

	public NilaiDto transformToDto (Nilai nilai) {
		NilaiDto nilaiDto = new NilaiDto();
		
		nilaiDto.setIdmaha(nilai.getIdmaha());
		nilaiDto.setIdmatkul(nilai.getIdmatkul());
		nilaiDto.setNilai(nilai.getNilai());
		nilaiDto.setKeterangan(nilai.getKeterangan());
		
		//RELASI
		nilaiDto.setNama(nilai.getMahasiswa().getNama());
		nilaiDto.setMataKuliah(nilai.getMatkul().getNama_matkul());
		return nilaiDto;
	}
}
