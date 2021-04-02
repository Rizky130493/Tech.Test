package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Nilai;

@Repository
public interface NilaiRepository extends JpaRepository<Nilai, Long>{
	Nilai findOneByIdmahaAndIdmatkul (long idmaha, long idmatkul);

	@Query(value = "SELECT AVG(nilai) FROM Psikotes.nilai WHERE idmaha = ?1" , nativeQuery = true)long getRatarata(long idmaha);
}
