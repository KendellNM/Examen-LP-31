package com.example.demo.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DoctorDao;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

@Component
public class DoctorDaoImpls implements DoctorDao{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Doctor create(Doctor c) {
		// TODO Auto-generated method stub
		return doctorRepository.save(c);
	}

	@Override
	public Doctor update(Doctor c) {
		// TODO Auto-generated method stub
		return doctorRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
	}

	@Override
	public Optional<Doctor> read(Long id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id);
	}

	@Override
	public List<Doctor> readAll() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}
	
	

}
