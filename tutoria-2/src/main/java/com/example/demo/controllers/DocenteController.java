package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Docente;
import com.example.demo.models.commons.RequestDocenteDto;
import com.example.demo.models.commons.Response;
import com.example.demo.services.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	
	@PostMapping
    public ResponseEntity<Response<Object>> save(@RequestBody RequestDocenteDto requestDocenteDto) {
        Docente savedDocente = docenteService.guardar(requestDocenteDto);
        
        if (savedDocente == null) {
            return ResponseEntity.badRequest().body(new Response<>("Documento ya ingresado"));
        }
        
        return ResponseEntity.ok(new Response<>("Docente guardado", savedDocente));
    }
	
	@GetMapping
	public ResponseEntity<List<Docente>> getAll(){
		
		return ResponseEntity.ok(docenteService.getAll());	
	}
	
	@PutMapping
	public ResponseEntity<Response<Object>> update(@RequestBody Docente docente){

		var docenteActualizado = docenteService.update(docente);
		
		if(docenteActualizado == null) {
			return ResponseEntity.ok(new Response<>("No se encontro el docente"));
		}
		
		return ResponseEntity.ok(new Response<>("Docente Actualizado", docenteActualizado));

	}
	
	@DeleteMapping("/{Id}")
	public ResponseEntity<Response<Object>> delete(@PathVariable("Id") int Id) {
		
		if(docenteService.delete(Id)) {
			
			return ResponseEntity.ok(new Response<>("Docente eliminado"));
			
		} else {
			return ResponseEntity.ok(new Response<>("Docente no se ha eliminado"));
		}
	}
}



/*
 {
	 "id": 0,
	 "nombres": "Juan",
	 "apellidos": "Rodriguez",
	 "celular": "3142687763",
	 "email": "prueba@gmail.com",
	 "numeroDocumento": "1110450635",
	 "tipoDocumento": "CC"
	}
 */