package com.example.demo.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NilaiDto;
import com.example.demo.dto.ResponseJson;
import com.example.demo.enumeration.responseCodes;
import com.example.demo.exception.notFoundException;
import com.example.demo.model.Nilai;
import com.example.demo.repository.NilaiRepository;
import com.example.demo.service.NilaiService;

@RestController
@RequestMapping("/api/psikotes")
public class NilaiController {
	@Autowired
	private NilaiRepository nilaiRepository;
	
	@Autowired 
	private NilaiService nilaiservice;
	
	//POST
	@PostMapping("/user")
	public Nilai postNilai(@Validated @RequestBody Nilai nilai) {
		return nilaiRepository.save(nilai);	
	}
	
	
	//GET
//	@RequestMapping(value = "/{idmaha}/{idmatkul}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<ResponseJson>getData(
//			@PathVariable(name = "idmaha", required = true, value = "") long idmaha,
//			@PathVariable(name = "idmatkul", required = true, value = "")long idmatkul
//			){
//		try {
//			Nilai nilai = nilaiRepository.findOneByIdmahaAndIdmatkul(idmaha, idmatkul);
//			if (nilai!= null) {
//				NilaiDto nilaiDto = nilaiservice.transformToDto(nilai);
//				return ResponseEntity.ok(new ResponseJson(responseCodes.SUCCESS, nilaiDto));
//			}else {
//				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseJson(responseCodes.NOTFOUND, "Data Not Found"));
//		} 
//		}catch (Exception e) {
//			StringWriter sw = new StringWriter();
//			PrintWriter pw = new PrintWriter(sw);
//			e.printStackTrace(pw);
//			String sStackTrace = sw.toString();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJson(responseCodes.OTHER, e.getMessage()));
//			}
//	}
	
	
	
	
	
	
	@RequestMapping(value = "/{idmaha}/{idmatkul}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseJson>getData(
			@PathVariable(name="idmaha", required=true, value="")long Idmaha,
			@PathVariable(name="idmatkul", required=true, value="") long Idmatkul
			){
		try {
			
			Nilai nilai = nilaiRepository.findOneByIdmahaAndIdmatkul(Idmaha, Idmatkul);
			if(nilai!=null) {
				NilaiDto nilaiDto = nilaiservice.transformToDto(nilai);
				return ResponseEntity.ok(new ResponseJson(responseCodes.SUCCESS, nilaiDto));
			}else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseJson(responseCodes.NOTFOUND, "Data Not Found"));
		} 
		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJson(responseCodes.OTHER, e.getMessage()));
			}
	}
	
	
	
	
	
	// GET BY ID
			@GetMapping("/user/{id}")
			public ResponseEntity<Nilai> getById(@PathVariable(value = "id") Long testId)
					throws notFoundException {
				Nilai course = nilaiRepository.findById(testId)
						.orElseThrow(() -> new notFoundException("Course not found for this id :: " + testId));
				return ResponseEntity.ok().body(course);
			}
			
			// PUT
			@PutMapping("/user/{id}")
			public ResponseEntity<Nilai> putNilai(@PathVariable(value = "id") Long id,
					@Validated @RequestBody Nilai nilaiDetails) throws notFoundException {
				Nilai nilai = nilaiRepository.findById(id)
						.orElseThrow(() -> new notFoundException("Course not found for this id :: " + id));
				
				nilai.setIdmaha(nilaiDetails.getIdmaha());
				nilai.setIdmatkul(nilaiDetails.getIdmatkul());
				nilai.setNilai(nilaiDetails.getNilai());
				nilai.setKeterangan(nilaiDetails.getKeterangan());
				final Nilai updatedCourse = nilaiRepository.save(nilai);
				return ResponseEntity.ok(updatedCourse);
			}
			
			//DELETE
			@DeleteMapping("/user/{id}")
			public Map<String, Boolean> deleteNilai(@PathVariable(value = "id") Long testId)
					throws notFoundException {
				Nilai nilai = nilaiRepository.findById(testId)
						.orElseThrow(() -> new notFoundException("Course not found for this id :: " + testId));

				nilaiRepository.delete(nilai);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
			}
			
			//GET RATA RATA
			@RequestMapping(value = "ratarata/{idmaha}", method = RequestMethod.GET)
			@ResponseBody
			public ResponseEntity<ResponseJson>getRata2(
					@PathVariable(name="idmaha", required=true, value="") long Idmaha
					)
			{
				try {
					long nilai = nilaiRepository.getRatarata(Idmaha);
					if(nilai!=0) {
						System.out.println(nilai);
						return ResponseEntity.ok(new ResponseJson(responseCodes.SUCCESS, nilai));
					}else {
						return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseJson(responseCodes.NOTFOUND, "Data Not Found"));
							} 
				} catch (Exception e) {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					e.printStackTrace(pw);
					String sStackTrace = sw.toString();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJson(responseCodes.OTHER, e.getMessage()));
					}
	}
}

			
			

			

