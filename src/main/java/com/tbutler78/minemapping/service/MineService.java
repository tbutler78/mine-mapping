package com.tbutler78.minemapping.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.repository.MineRepository;

@Service

public class MineService 
{
	//private UserDao userDao;
	
	@Autowired
	private MineRepository mineRepository;

	
	public List<Mine> findAll(){
		return mineRepository.findAll();
	}
	
	public List<Mine> findByCounty(String county){
		List<Mine> mines = mineRepository.findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull(county); 
		Collections.sort(mines);
		return mines;
	}
	
	public Mine findMine(){
		return mineRepository.findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull("Adams").get((int)Math.random());
	}
	
}
