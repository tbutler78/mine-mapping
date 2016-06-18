package com.tbutler78.minemapping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name="mines")
@Getter
@Setter
@ToString
public class Mine  implements Serializable, Comparable<Mine>{

	private static final long serialVersionUID = -5708387226479386241L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String newLoc;
	private String mapLoc;
	private String deposit;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	private String locationType;
	private BigDecimal dmsLat;
	private BigDecimal dmsLong;
	@Column(name="24kquad")
	private String twentyFourQuad;
	@Column(name="100kQuad") 
	private String oneHundredQuad;
	
	private String countyName;
	private String trs;
	private String landOwner;
	private String idahoRegion;
	private String fsAgencyName;
	private String orangeNum;
	
	@Column(name="1x2degreeQuadrangle")
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
