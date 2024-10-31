package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Doctor;

public interface DoctorDao {
	Doctor create(Doctor c);
	Doctor update(Doctor c);
	void delete(Long id);
	Optional<Doctor> read(Long id);
	List<Doctor> readAll();
}
