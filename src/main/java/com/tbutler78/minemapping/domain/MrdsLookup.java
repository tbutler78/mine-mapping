package com.tbutler78.minemapping.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "mrds_lookup")
public class MrdsLookup {


	@Id
	private Long id;
	private String secQuad;
	private String siteName;
	private String county2;
	private String lon;
	private String mrdsLookupKey;
	private String secQuads;
	private String utmEast;
	private String mrdsRec;
	private String commodity;
	private String district;
	private String utmNorth;
	private String utmZone;
	private String town;
	private String sequenceNumber;
	private String lat;
	private String section;
	private String county;
	private String range;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecQuad() {
		return secQuad;
	}

	public void setSecQuad(String secQuad) {
		this.secQuad = secQuad;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCounty2() {
		return county2;
	}

	public void setCounty2(String county2) {
		this.county2 = county2;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getMrdsLookupKey() {
		return mrdsLookupKey;
	}

	public void setMrdsLookupKey(String mrdsLookupKey) {
		this.mrdsLookupKey = mrdsLookupKey;
	}

	public String getSecQuads() {
		return secQuads;
	}

	public void setSecQuads(String secQuads) {
		this.secQuads = secQuads;
	}

	public String getUtmEast() {
		return utmEast;
	}

	public void setUtmEast(String utmEast) {
		this.utmEast = utmEast;
	}

	public String getMrdsRec() {
		return mrdsRec;
	}

	public void setMrdsRec(String mrdsRec) {
		this.mrdsRec = mrdsRec;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUtmNorth() {
		return utmNorth;
	}

	public void setUtmNorth(String utmNorth) {
		this.utmNorth = utmNorth;
	}

	public String getUtmZone() {
		return utmZone;
	}

	public void setUtmZone(String utmZone) {
		this.utmZone = utmZone;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MrdsLookup that = (MrdsLookup) o;

		return Objects.equals(this.commodity, that.commodity) &&
				Objects.equals(this.county, that.county) &&
				Objects.equals(this.county2, that.county2) &&
				Objects.equals(this.district, that.district) &&
				Objects.equals(this.id, that.id) &&
				Objects.equals(this.lat, that.lat) &&
				Objects.equals(this.lon, that.lon) &&
				Objects.equals(this.mrdsLookupKey, that.mrdsLookupKey) &&
				Objects.equals(this.mrdsRec, that.mrdsRec) &&
				Objects.equals(this.range, that.range) &&
				Objects.equals(this.secQuad, that.secQuad) &&
				Objects.equals(this.secQuads, that.secQuads) &&
				Objects.equals(this.section, that.section) &&
				Objects.equals(this.sequenceNumber, that.sequenceNumber) &&
				Objects.equals(this.siteName, that.siteName) &&
				Objects.equals(this.town, that.town) &&
				Objects.equals(this.utmEast, that.utmEast) &&
				Objects.equals(this.utmNorth, that.utmNorth) &&
				Objects.equals(this.utmZone, that.utmZone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commodity, county, county2, district, id, lat,
				lon, mrdsLookupKey, mrdsRec, range, secQuad,
				secQuads, section, sequenceNumber, siteName, town,
				utmEast, utmNorth, utmZone);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
				.add("commodity = " + commodity)
				.add("county = " + county)
				.add("county2 = " + county2)
				.add("district = " + district)
				.add("id = " + id)
				.add("lat = " + lat)
				.add("lon = " + lon)
				.add("mrdsLookupKey = " + mrdsLookupKey)
				.add("mrdsRec = " + mrdsRec)
				.add("range = " + range)
				.add("secQuad = " + secQuad)
				.add("secQuads = " + secQuads)
				.add("section = " + section)
				.add("sequenceNumber = " + sequenceNumber)
				.add("siteName = " + siteName)
				.add("town = " + town)
				.add("utmEast = " + utmEast)
				.add("utmNorth = " + utmNorth)
				.add("utmZone = " + utmZone)
				.toString();
	}
}
