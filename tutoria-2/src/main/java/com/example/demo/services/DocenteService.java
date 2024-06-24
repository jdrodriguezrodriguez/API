package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Docente;
import com.example.demo.models.commons.RequestDocenteDto;
import com.example.demo.repositories.IDocenteRepository;

@Service
public class DocenteService {
	
	
	@Autowired	/*CREAMOS INSTANCIA CON AUTWIRED*/
private IDocenteRepository docenteRepository;
    
    public Docente guardar(RequestDocenteDto docenteDto) {

        Docente existingDocente = docenteRepository.findByNumeroDocumento(docenteDto.getNumeroDocumento());
        if (existingDocente != null) {
           
            return null;
        }
        
        Docente doc = mapperDocente(docenteDto);
        return docenteRepository.save(doc);
    }
	
	public List<Docente> getAll(){
		return (List<Docente>) docenteRepository.findAll();
	}
	
	public Docente update(Docente docente) {
		try {
			if(existeDocente(docente.getId())){
				return docenteRepository.save(docente);
			}
			return null;
			
		}catch(Exception ex) {
			return null;
		}	
	}
	
	public boolean delete(int Id) {
		
		if(existeDocente(Id)){
			docenteRepository.deleteById(Id);
			return true;
		}
		return false;
		
	}
	
	public boolean existeDocente(int Id) {	
		return docenteRepository.existsById(Id) ? true : false;
	}	
	
	private Docente mapperDocente(RequestDocenteDto docente) {
		
		Docente doc = new Docente();
		doc.setNombres(docente.getNombres());
		doc.setApellidos(docente.getApellidos());
		doc.setCelular(docente.getCelular());
		doc.setDireccion(docente.getDireccion());
		doc.setEmail(docente.getEmail());
		doc.setNumeroDocumento(docente.getNumeroDocumento());
		doc.setTipoDocumento(docente.getTipoDocumento());
		doc.setId(0);
		
		return doc;
	}
		
}	

