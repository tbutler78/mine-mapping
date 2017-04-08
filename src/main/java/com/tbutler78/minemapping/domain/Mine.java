package com.tbutler78.minemapping.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="mines")
public class Mine  implements Serializable, Comparable<Mine>{

	private static final long serialVersionUID = -5708387226479386241L;

	@Id
	private long id;

	private String newLoc;
	private String mapLoc;
	private String deposit;

	private BigDecimal latitude;

	private BigDecimal longitude;
	private String locationType;
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


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mine [id=");
		builder.append(id);
		builder.append(", newLoc=");
		builder.append(newLoc);
		builder.append(", mapLoc=");
		builder.append(mapLoc);
		builder.append(", deposit=");
		builder.append(deposit);
		builder.append(", Latitude=");
		builder.append(latitude);
		builder.append(", Longitude=");
		builder.append(longitude);
		builder.append(", locationType=");
		builder.append(locationType);
		builder.append(", dmsLat=");
		builder.append(dmsLat);
		builder.append(", dmsLong=");
		builder.append(dmsLong);
		builder.append(", twentyFourQuad=");
		builder.append(twentyFourQuad);
		builder.append(", oneHundredQuad=");
		builder.append(oneHundredQuad);
		builder.append(", countyName=");
		builder.append(countyName);
		builder.append(", trs=");
		builder.append(trs);
		builder.append(", landOwner=");
		builder.append(landOwner);
		builder.append(", idahoRegion=");
		builder.append(idahoRegion);
		builder.append(", fsAgencyName=");
		builder.append(fsAgencyName);
		builder.append(", orangeNum=");
		builder.append(orangeNum);
		builder.append(", oneByTwoDegreeQuad=");
		builder.append(oneByTwoDegreeQuad);
		builder.append(", township=");
		builder.append(township);
		builder.append(", range=");
		builder.append(range);
		builder.append(", section=");
		builder.append(section);
		builder.append(", longwgs=");
		builder.append(longwgs);
		builder.append(", latwgs=");
		builder.append(latwgs);
		builder.append(", mrdsrec=");
		builder.append(mrdsrec);
		builder.append(", point=");
		builder.append(point);
		builder.append("]");
		return builder.toString();
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


}
