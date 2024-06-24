package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Docente;

@Repository
public interface IDocenteRepository extends CrudRepository<Docente, Integer> {
	Docente findByNumeroDocumento(String numeroDocumento);
}
