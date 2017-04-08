package com.tbutler78.minemapping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;


@Entity
@Table(name="locations")
public class Location  implements Serializable, Comparable<Location>{

	private static final long serialVersionUID = 8257252570649825576L;

	@Id
	private long id;
	
	private String deposit;
	private Double Latitude;
	private Double Longitude;
	private String MilsREF;
	private String MRDSREC;
	private String OrangeNumber;
	private Point point;

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
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
	
	
	 @Override
	public String toString() {
		return "Location [id=" + id + ", deposit=" + deposit + ", Latitude="
				+ Latitude + ", Longitude=" + Longitude + "]";
	}

	public int compareTo(Location other) {
		 	if (this.deposit == null){
		 		return -1;
		 	}
		 	else if (other.getDeposit() == null){
		 		return 1;
		 	}
		 	else if (this.deposit== (other.getDeposit()))
	            return 0;
	        else if ((this.deposit).compareTo(other.getDeposit()) > 0)
	            return 1;
	        else
	            return -1;
	    }

}
