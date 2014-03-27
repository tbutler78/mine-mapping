package com.tbutler78.minemapping.domain;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tbutler78.minemapping.service.LocationService;
import com.tbutler78.minemapping.springapp.config.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class LocationTest {
	
	@Autowired
	LocationService lService;

//	@Test
	public void testLocation(){
		List<Location> locations = lService.findAll();
		Collections.sort(locations);
		for (Location l : locations){
			System.out.println(l.toString());
		}
		Location location = new Location();
		Double x = new Double(42.92828);
		Double y = new Double(-116.7737);
		location.setPoint(x,y);
		System.out.println(location.getPoint().toString());
		
	}
}
