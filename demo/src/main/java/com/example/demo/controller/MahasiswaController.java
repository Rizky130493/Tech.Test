package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ResponseJson;
import com.example.demo.enumeration.responseCodes;
import com.example.demo.model.Mahasiswa;
import com.example.demo.repository.MahasiswaRepository;
import com.example.demo.service.ExcelService;
import com.example.demo.service.mahasiswaService;


@RestController

@RequestMapping("/api/psikotes")
public class MahasiswaController {
	@Autowired
	MahasiswaRepository mahasiswaRepository;
	
	@Autowired
	mahasiswaService MahasiswaService;
	
	@Autowired
	ExcelService excelService;
	
	@GetMapping("/getAll")
	public List<Mahasiswa> getAll(){
		return (List<Mahasiswa>) mahasiswaRepository.findAll();
	}
	
	@PostMapping("/Upload")
	public ResponseEntity<ResponseJson> getExcelToDB(@RequestParam("file") MultipartFile reapExcelDataFile)
	throws IOException{
		try {
			 excelService.ReadDataFromExcel(reapExcelDataFile);
		        return ResponseEntity.status(HttpStatus.OK).body(new ResponseJson(responseCodes.SUCCESS, "OK"));
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJson(responseCodes.OTHER, e.getMessage()));
		}
	}
}
