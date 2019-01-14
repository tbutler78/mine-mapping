package com.tbutler78.minemapping.domain;

import java.io.Serializable;
import java.util.Objects;

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
	private Double latitude;
	private Double longitude;
	private String milsREF;
	private String mrdsrec;
	private String orangeNumber;
	private Point point;

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getMilsREF() {
		return milsREF;
	}

	public void setMilsREF(String milsREF) {
		this.milsREF = milsREF;
	}

	public String getMrdsrec() {
		return mrdsrec;
	}

	public void setMrdsrec(String mrdsrec) {
		this.mrdsrec = mrdsrec;
	}

	public String getOrangeNumber() {
		return orangeNumber;
	}

	public void setOrangeNumber(String orangeNumber) {
		this.orangeNumber = orangeNumber;
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
				+ latitude + ", Longitude=" + longitude + "]";
	}

	public int compareTo(Location other) {
		 	if (this.deposit == null){
		 		return -1;
		 	}
		 	else if (this.deposit.equals(other.getDeposit()))
	            return 0;
	        else if ((this.deposit).compareTo(other.getDeposit()) > 0)
	            return 1;
	        else
	            return -1;
	    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Objects.equals(mrdsrec, location.mrdsrec);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mrdsrec);
    }
}
