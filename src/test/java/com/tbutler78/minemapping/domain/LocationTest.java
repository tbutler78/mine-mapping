package com.tbutler78.minemapping.domain;

import java.util.Collections;
import java.util.List;








import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tbutler78.minemapping.service.LocationService;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.service.NameService;
import com.tbutler78.minemapping.springapp.config.AppConfig;
import com.tbutler78.minemapping.web.MineCommand;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class LocationTest {
	
	private static TestUtils util;
	
	private static Logger log = LoggerFactory.getLogger(LocationTest.class);
	
	@Autowired
	LocationService lService;

	@Autowired
	NameService nameService;

	@Autowired
	MineService mineService;

	@Test
	public void testMines(){
		
	
		
		/*
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
		writer.
		*/
		List<Mine> mines = mineService.findByCounty("Owyhee");
		MineCommand cmd = new MineCommand(mines);
		log.debug("Bottom: " + cmd.getBottomOuterBound());
		log.debug("Top: " + cmd.getTopOuterBound());
		log.debug("Left: " + cmd.getLeftOuterBound());
		log.debug("Right: " + cmd.getRightOuterBound());
		
		for (int i=0; i< 20; i++){
		Mine mine = mines.get(RandomUtils.nextInt(mines.size()));
		//TestUtils.dumpList(mines);
		GeometryFactory gf = new GeometryFactory();
		log.debug(mine.toString());
		
		if (mine.getLatitude() != null && mine.getLongitude() != null){
		Coordinate coordinate = new Coordinate(mine.getLatitude().doubleValue(), mine.getLongitude().doubleValue());
		log.debug("Coordinate{}", coordinate.toString());
		Point p = gf.createPoint(coordinate);
		log.debug(p.toString());
		log.debug(p.getGeometryType());
		}
		
		}
				
	}
	
	

//	@Test
	public void testName(){
		List<Name> names = nameService.findAll();
		TestUtils.dumpList(names);
	}
	
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
