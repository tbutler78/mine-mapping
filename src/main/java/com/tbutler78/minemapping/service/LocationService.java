package com.tbutler78.minemapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tbutler78.minemapping.domain.Location;
import com.tbutler78.minemapping.repositories.LocationRepository;




@Service

public class LocationService 
{
	//private UserDao userDao;
	
	@Autowired
	private LocationRepository locationRepository;
	
	/*
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	public List<Location> findAll() {
		//return userDao.findAll();
		return locationRepository.findAll();
	}
/*
	public User create(User user) {
		//return userDao.create(user);
		return userRepository.save(user);
	}

	public User findUserById(int id) {
		//return userDao.findUserById(id);
		return userRepository.findOne(id);
	}

	public User login(String email, String password) {
		//return userDao.login(email,password);
		//return userRepository.login(email,password);
		return userRepository.findByEmailAndPassword(email,password);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	*/
	
}
