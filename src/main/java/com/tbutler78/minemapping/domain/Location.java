package com.tbutler78.minemapping.domain;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.operation.overlay.PointBuilder;

public class Location {
	private String Deposit;
	private Double Latitude;
	private Double Longitude;
	private String MilsREF;
	private String MRDSREC;
	private String OrangeNumber;
	private Point point;

	public String getDeposit() {
		return Deposit;
	}

	public void setDeposit(String deposit) {
		Deposit = deposit;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public String getMilsREF() {
		return MilsREF;
	}

	public void setMilsREF(String milsREF) {
		MilsREF = milsREF;
	}

	public String getMRDSREC() {
		return MRDSREC;
	}

	public void setMRDSREC(String mRDSREC) {
		MRDSREC = mRDSREC;
	}

	public String getOrangeNumber() {
		return OrangeNumber;
	}

	public void setOrangeNumber(String orangeNumber) {
		OrangeNumber = orangeNumber;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public void setPoint(Double latitude, Double longitude){
		this.point = new GeometryFactory().createPoint(new Coordinate(latitude,longitude));
		
	}
	


}
