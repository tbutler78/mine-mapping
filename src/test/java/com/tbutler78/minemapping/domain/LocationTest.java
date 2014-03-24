package com.tbutler78.minemapping.domain;

import org.junit.Test;



public class LocationTest {

	@Test
	public void testLocation(){
		Location location = new Location();
		Double x = new Double(42.92828);
		Double y = new Double(-116.7737);
		location.setPoint(x,y);
		System.out.println(location.getPoint().toString());
		
	}
}
