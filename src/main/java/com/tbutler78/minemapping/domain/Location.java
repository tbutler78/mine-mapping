package com.tbutler78.minemapping.domain;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="locations")
@Getter
@Setter
@Log
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
