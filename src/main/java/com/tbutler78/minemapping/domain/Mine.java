package com.tbutler78.minemapping.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mines")
public class Mine implements Serializable, Comparable<Mine> {

	private static final long serialVersionUID = -5708387226479386241L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * Primary Key for Access: For the main entry for each property, the
	 * SequenceNumber is the same as the Property Number.
	 */
	private String sequenceNumber;

	/**
	 * Property Number, including quadrangle abbreviation and sequence number. This
	 * field is archaic and now obsolete.
	 */
	private String newLoc;

	/**
	 * The Property Number, without the quadrangle identifier.
	 */
	private String mapLoc;

	/**
	 * Name and synonym names for the mine or prospect.
	 */
	private String deposit;

	/**
	 * Latitude in NAD27, as digitized from 1:250,000 base AND see "location_type"
	 * field for information about updated locations.
	 */
	private BigDecimal latitude;

	/**
	 * Longitude in NAD 27, as digitized from 1:250,000 base AND see "location_type"
	 * field for information about updated locations.
	 */
	private BigDecimal longitude;

	/**
	 * Location information: 3= Locations updated in 2009 using data from mineral
	 * property files and verified on 1:24,000 scale quadrangles.
	 */
	private Integer locationType;

	/**
	 * Degree Minute Second Latitude, as digitized from 1:250,000 base; or as
	 * updated from field work (see Updates table) AND see "location_type" field for
	 * information about updated locations.
	 */
	private BigDecimal dmsLat;

	/**
	 * Degree Minute Second Longitude, as digitized from 1:250,000 base; or as
	 * updated from field work (see Updates table) AND see "location_type" field for
	 * information about updated locations.
	 */
	private BigDecimal dmsLong;

	/**
	 * Name of the USGS 1:24,000 Scale Quad Name. This was taken from the USGS
	 * database for Idaho and referenced against IDWR 1:24,000 Quad index. Names
	 * were changed based on the name of the USGS quad. Some common names were
	 * spelled out (ex. Mtn to Mountain).
	 */
	@Column(name = "twentyfour_k_kquad")
	private String twentyFourQuad;

	/**
	 * Name of the USGS 1:100,000 Scale Quad name. This was taken from the USGS
	 * database for Idaho and referenced against IDWR 1:100,000 Quad index. Names
	 * were changed based on the name of the USGS quad. Some common names were
	 * spelled out (ex. Mtn to Mountain).
	 */
	@Column(name = "hundred_k_quad")
	private String oneHundredQuad;

	/**
	 * County Names of Idaho s (Idaho Counties in ALL CAPS).
	 */
	private String countyName;
	private String trs;
	/**
	 * Surface Management Agency of Idaho; based on IGS mine locations against 2009
	 * INSIDE IDAHO (http://inside.uidaho.edu)
	 */
	private String landOwner;
	private String idahoRegion;
	/**
	 * Name of U.S. Forest or Forest Service administrative unit.
	 */
	private String fsAgencyName;
	/**
	 * Old number associated with IGS "Mines and Prospects Maps" series; last
	 * updated in 1992
	 */
	private String orangeNum;

	/**
	 * 1x2 degreeQuadrangle name
	 */
	@Column(name = "one_by_two_degreeQuadrangle")
	private String oneByTwoDegreeQuad;

	/**
	 * Idaho PLSS Township.
	 */
	private String township;
	/**
	 * Idaho PLSS Range.
	 */
	private String range;
	/**
	 * Idaho PLSS Section.
	 */
	private String section;

	private String qSection;

	/**
	 * Longitude in WGS84 datum: as digitized from 1:250,000 base AND see
	 * "location_type" field for information about updated locations.
	 */
	@Column(name = "lon_WGS84")
	private BigDecimal longwgs;

	/**
	 * Latitude in WGS84 datum: as digitized from 1:250,000 base AND see
	 * "location_type" field for information about updated locations.
	 */
	@Column(name = "lat_WGS84")
	private BigDecimal latwgs;
	private String mrdsrec;

	private String point;

	/**
	 * Potential Mining District (see documentation for source and reference data!).
	 */
	private String miningDistrict;

	/**
	 * ZIP attribute for property.
	 */
	private Long zipCode;

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

	public void addPropertyFileScan(PropertyFileScan propertyFileScan) {
		this.propertyFileScans.add(propertyFileScan);
	}

	public String getqSection() {
		return qSection;
	}

	public void setqSection(String qSection) {
		this.qSection = qSection;
	}

	public String getMiningDistrict() {
		return miningDistrict;
	}

	public void setMiningDistrict(String miningDistrict) {
		this.miningDistrict = miningDistrict;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public int compareTo(Mine other) {
		if (this.deposit == null) {
			return -1;
		} else if (this.deposit.equals(other.getDeposit())) {
            return 0;
        }
		else if ((this.deposit).compareTo(other.getDeposit()) > 0) {
            return 1;
        }
		else
			return -1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Mine mine = (Mine) o;
		return Objects.equals(sequenceNumber, mine.sequenceNumber);
	}

	@Override
	public int hashCode() {

		return Objects.hash(sequenceNumber);
	}

	@Override
	public String toString() {
		return "Mine{" + "id=" + id + ", sequenceNumber='" + sequenceNumber + '\'' + ", newLoc='" + newLoc + '\''
				+ ", mapLoc='" + mapLoc + '\'' + ", deposit='" + deposit + '\'' + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", locationType='" + locationType + '\'' + ", dmsLat=" + dmsLat
				+ ", dmsLong=" + dmsLong + ", twentyFourQuad='" + twentyFourQuad + '\'' + ", oneHundredQuad='"
				+ oneHundredQuad + '\'' + ", countyName='" + countyName + '\'' + ", trs='" + trs + '\''
				+ ", landOwner='" + landOwner + '\'' + ", idahoRegion='" + idahoRegion + '\'' + ", fsAgencyName='"
				+ fsAgencyName + '\'' + ", orangeNum='" + orangeNum + '\'' + ", oneByTwoDegreeQuad='"
				+ oneByTwoDegreeQuad + '\'' + ", township='" + township + '\'' + ", range='" + range + '\''
				+ ", section='" + section + '\'' + ", longwgs=" + longwgs + ", latwgs=" + latwgs + ", mrdsrec='"
				+ mrdsrec + '\'' + ", point='" + point + '\'' + ", propertyFileScans=" + propertyFileScans + '}';
	}
}
