package com.tbutler78.minemapping.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tbutler78.minemapping.MineMappingApplicationTest;
import com.tbutler78.minemapping.service.LocationService;
import com.tbutler78.minemapping.service.MineService;
import com.tbutler78.minemapping.service.NameService;
import com.tbutler78.minemapping.web.MineCommand;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


public class LocationTest extends MineMappingApplicationTest {

	private static TestUtils util;

	private static Logger log = LoggerFactory.getLogger(LocationTest.class);

	@Autowired
	LocationService lService;

	@Autowired
	NameService nameService;

	@Autowired
	MineService mineService;

	@Mock
	MineCommand mineCommand;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


	//@Test
	public void testMines(){



		/*
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
		writer.
		*/
		List<Mine> mines = mineService.findByCounty("Owyhee");
		if (mines == null)
			mines = new ArrayList<>();
		MineCommand cmd = mineCommand;//new MineCommand(mines);
		log.debug("Bottom: " + cmd.getBottomOuterBound());
		log.debug("Top: " + cmd.getTopOuterBound());
		log.debug("Left: " + cmd.getLeftOuterBound());
		log.debug("Right: " + cmd.getRightOuterBound());
		log.debug("testing");

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



	@Test
	public void testName(){
		List<Name> names = nameService.findAll();
		TestUtils.dumpList(names);
	}

	@Test
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
