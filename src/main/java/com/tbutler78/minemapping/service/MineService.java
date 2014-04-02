package com.tbutler78.minemapping.service;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.domain.Name;
import com.tbutler78.minemapping.repositories.MineRepository;
import com.tbutler78.minemapping.repositories.NameRepository;

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
		return mineRepository.findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull("Owyhee").get((int)Math.random());
	}
	
}
	