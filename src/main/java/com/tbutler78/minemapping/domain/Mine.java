package com.tbutler78.minemapping.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name="mines")
public class Mine  implements Serializable, Comparable<Mine>{

	private static final long serialVersionUID = -5708387226479386241L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	private String sequenceNumber;
	private String newLoc;
	private String mapLoc;
	private String deposit;

	private BigDecimal latitude;

	private BigDecimal longitude;
	private Integer locationType;
	private BigDecimal dmsLat;
	private BigDecimal dmsLong;
	@Column(name="twentyfour_k_kquad")
	private String twentyFourQuad;
	@Column(name="hundred_k_quad")
	private String oneHundredQuad;

	private String countyName;
	private String trs;
	private String landOwner;
	private String idahoRegion;
	private String fsAgencyName;
	private String orangeNum;

	@Column(name="one_by_two_degreeQuadrangle")
	private String oneByTwoDegreeQuad;

	private String township;
	private String range;
	private String section;

	@Column(name="lon_WGS84")
	private BigDecimal longwgs;
	@Column(name="lat_WGS84")
	private BigDecimal latwgs;
	private String mrdsrec;

	private String point;
	@Transient
	private List<PropertyFileScan> propertyFileScans;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getNewLoc() {
		return newLoc;
	}

	public void setNewLoc(String newLoc) {
		this.newLoc = newLoc;
	}

	public String getMapLoc() {
		return mapLoc;
	}

	public void setMapLoc(String mapLoc) {
		this.mapLoc = mapLoc;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Integer getLocationType() {
		return locationType;
	}

	public void setLocationType(Integer locationType) {
		this.locationType = locationType;
	}

	public BigDecimal getDmsLat() {
		return dmsLat;
	}

	public void setDmsLat(BigDecimal dmsLat) {
		this.dmsLat = dmsLat;
	}

	public BigDecimal getDmsLong() {
		return dmsLong;
	}

	public void setDmsLong(BigDecimal dmsLong) {
		this.dmsLong = dmsLong;
	}

	public String getTwentyFourQuad() {
		return twentyFourQuad;
	}

	public void setTwentyFourQuad(String twentyFourQuad) {
		this.twentyFourQuad = twentyFourQuad;
	}

	public String getOneHundredQuad() {
		return oneHundredQuad;
	}

	public void setOneHundredQuad(String oneHundredQuad) {
		this.oneHundredQuad = oneHundredQuad;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getTrs() {
		return trs;
	}

	public void setTrs(String trs) {
		this.trs = trs;
	}

	public String getLandOwner() {
		return landOwner;
	}

	public void setLandOwner(String landOwner) {
		this.landOwner = landOwner;
	}

	public String getIdahoRegion() {
		return idahoRegion;
	}

	public void setIdahoRegion(String idahoRegion) {
		this.idahoRegion = idahoRegion;
	}

	public String getFsAgencyName() {
		return fsAgencyName;
	}

	public void setFsAgencyName(String fsAgencyName) {
		this.fsAgencyName = fsAgencyName;
	}

	public String getOrangeNum() {
		return orangeNum;
	}

	public void setOrangeNum(String orangeNum) {
		this.orangeNum = orangeNum;
	}

	public String getOneByTwoDegreeQuad() {
		return oneByTwoDegreeQuad;
	}

	public void setOneByTwoDegreeQuad(String oneByTwoDegreeQuad) {
		this.oneByTwoDegreeQuad = oneByTwoDegreeQuad;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public BigDecimal getLongwgs() {
		return longwgs;
	}

	public void setLongwgs(BigDecimal longwgs) {
		this.longwgs = longwgs;
	}

	public BigDecimal getLatwgs() {
		return latwgs;
	}

	public void setLatwgs(BigDecimal latwgs) {
		this.latwgs = latwgs;
	}

	public String getMrdsrec() {
		return mrdsrec;
	}

	public void setMrdsrec(String mrdsrec) {
		this.mrdsrec = mrdsrec;
	}


	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public List<PropertyFileScan> getPropertyFileScans() {
		return propertyFileScans;
	}

	public void setPropertyFileScans(List<PropertyFileScan> propertyFileScans) {
		this.propertyFileScans = propertyFileScans;
	}

	public void addPropertyFileScan(PropertyFileScan propertyFileScan){
		this.propertyFileScans.add(propertyFileScan);
	}

	@Override
	public int compareTo(Mine other) {
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


	@Override
	public String toString() {
		return "Mine{" +
				"id=" + id +
				", sequenceNumber='" + sequenceNumber + '\'' +
				", newLoc='" + newLoc + '\'' +
				", mapLoc='" + mapLoc + '\'' +
				", deposit='" + deposit + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", locationType='" + locationType + '\'' +
				", dmsLat=" + dmsLat +
				", dmsLong=" + dmsLong +
				", twentyFourQuad='" + twentyFourQuad + '\'' +
				", oneHundredQuad='" + oneHundredQuad + '\'' +
				", countyName='" + countyName + '\'' +
				", trs='" + trs + '\'' +
				", landOwner='" + landOwner + '\'' +
				", idahoRegion='" + idahoRegion + '\'' +
				", fsAgencyName='" + fsAgencyName + '\'' +
				", orangeNum='" + orangeNum + '\'' +
				", oneByTwoDegreeQuad='" + oneByTwoDegreeQuad + '\'' +
				", township='" + township + '\'' +
				", range='" + range + '\'' +
				", section='" + section + '\'' +
				", longwgs=" + longwgs +
				", latwgs=" + latwgs +
				", mrdsrec='" + mrdsrec + '\'' +
				", point='" + point + '\'' +
				", propertyFileScans=" + propertyFileScans +
				'}';
	}
}
