package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.Name;
import com.tbutler78.minemapping.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NameService 
{
	//private UserDao userDao;
	
	@Autowired
	private NameRepository nameRepository;

	
	public List<Name> findAll(){
		return nameRepository.findAll();
	}
	
}
