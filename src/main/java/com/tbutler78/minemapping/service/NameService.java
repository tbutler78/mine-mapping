package com.tbutler78.minemapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbutler78.minemapping.domain.Name;
import com.tbutler78.minemapping.repository.NameRepository;

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
