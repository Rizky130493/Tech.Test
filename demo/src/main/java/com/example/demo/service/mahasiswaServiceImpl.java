package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mahasiswa;
import com.example.demo.repository.MahasiswaRepository;


@Service
public class mahasiswaServiceImpl implements mahasiswaService{
	@Autowired
	private MahasiswaRepository MahasiswaRepo;
	
	@Override
	public Mahasiswa save(Mahasiswa Mahasiswa) {
		return MahasiswaRepo.save(Mahasiswa);
	}
}
