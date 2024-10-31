package com.example.demo.controller;

import com.example.demo.entity.Especialidad;
import com.example.demo.serviceImpl.EspecialidadServiceImpls;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/especialidad")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class EspecialidadController { 

	@Autowired
	private EspecialidadServiceImpls especialidadServiceImpls;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> readAll() {
		try {
			List<Especialidad> o = especialidadServiceImpls.readAll();
			
			if(o.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(o, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	@PostMapping
	public ResponseEntity<Especialidad> crearEspecialidad(@Valid @RequestBody Especialidad cat) {
		//TODO: process POST request
		try {
			Especialidad ordenes = especialidadServiceImpls.create(cat);
			return new ResponseEntity<>(ordenes, HttpStatus.ACCEPTED);
		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEspecialidad(@PathVariable("id") Long id, @Valid @RequestBody Especialidad cat) {
		//TODO: process PUT request
		Optional<Especialidad> ordenes = especialidadServiceImpls.read(id);
		if (ordenes.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(especialidadServiceImpls.update(cat), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> readEspecialidad(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			Especialidad o = especialidadServiceImpls.read(id).get();
			return new ResponseEntity<>(o, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Especialidad> delEspecialidad(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			especialidadServiceImpls.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
