package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Matkul;



@Repository
public interface MatkulRepository extends JpaRepository <Matkul ,Long>{

}
