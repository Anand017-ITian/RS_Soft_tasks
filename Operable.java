package com.acc.service;

import java.util.List;

import com.acc.model.Doctor;

public interface Operable {
	public List<Doctor> findAll();
	public List<Doctor> findAll(String specialist);
	public Doctor find(int id);
	public void delete(int id);
	public void add(Doctor doc);
	public void update(int id);
	

}
