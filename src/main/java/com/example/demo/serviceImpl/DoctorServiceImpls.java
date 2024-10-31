package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DoctorDao;
import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceImpls implements DoctorService{

	@Autowired
	private DoctorDao dao; 
	
	@Override
	public Doctor create(Doctor c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Doctor update(Doctor c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Doctor> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Doctor> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}
	
	

}
