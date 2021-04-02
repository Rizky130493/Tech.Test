package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Mahasiswa;



@Service
public interface mahasiswaService {
	public Mahasiswa save(Mahasiswa mahasiswa);
}
