package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Doctor;
import com.example.demo.serviceImpl.DoctorServiceImpls;
 
import jakarta.validation.Valid ;
 
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class DoctorController {

	@Autowired
	private DoctorServiceImpls doctorServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Doctor>> readAll() {
		try {
			List<Doctor> o = doctorServiceImpl.readAll();
			
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
	public ResponseEntity<Doctor> crearDoctor(@Valid @RequestBody Doctor cat) {
		//TODO: process POST request
		try {
			Doctor ordenes = doctorServiceImpl.create(cat);
			return new ResponseEntity<>(ordenes, HttpStatus.ACCEPTED);
		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDoctor(@PathVariable("id") Long id, @Valid @RequestBody Doctor cat) {
		//TODO: process PUT request
		Optional<Doctor> ordenes = doctorServiceImpl.read(id);
		if (ordenes.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(doctorServiceImpl.update(cat), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> readDoctor(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			Doctor o = doctorServiceImpl.read(id).get();
			return new ResponseEntity<>(o, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Doctor> delDoctor(@PathVariable("id") Long id) {
		//TODO: process PUT request
		try {
			doctorServiceImpl.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
