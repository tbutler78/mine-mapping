package com.tbutler78.minemapping.web;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import com.tbutler78.minemapping.domain.Mine;

public class MineCommand {
	private List<Mine> mines;
	private BigDecimal leftOuterBound = new BigDecimal(0);
	private BigDecimal rightOuterBound = new BigDecimal(0);
	private BigDecimal topOuterBound = new BigDecimal(0);
	private BigDecimal bottomOuterBound = new BigDecimal(0);
	private SortedSet<BigDecimal> latitudeRange;
	private SortedSet<BigDecimal> longitudeRange;
	private BigDecimal middleLat;
	private BigDecimal middleLong;
	
	public MineCommand(List<Mine> mines){

		this.mines = mines;
		this.latitudeRange = new TreeSet<BigDecimal>();
		this.longitudeRange = new TreeSet<BigDecimal>();
		for (Mine m : mines){
		
			this.latitudeRange.add(m.getLatitude());
			this.longitudeRange.add(m.getLongitude());
		}
		
		
		this.leftOuterBound = longitudeRange.first();
		this.rightOuterBound = longitudeRange.last();
		this.topOuterBound = latitudeRange.first();
		this.bottomOuterBound = latitudeRange.last();
		this.middleLat = bottomOuterBound.subtract(topOuterBound).divide(new BigDecimal(2)).add(topOuterBound) ;
		this.middleLong = leftOuterBound.subtract(rightOuterBound).divide(new BigDecimal(2)).add(rightOuterBound) ;
        
       
		
			/*
			if (m.getLongitude() != null) {
			if (this.leftOuterBound.compareTo(m.getLongitude()) > 0 )
				this.leftOuterBound = m.getLongitude();
			
			else if (this.rightOuterBound.compareTo(m.getLongitude()) > 0)
				this.rightOuterBound = m.getLongitude();
			
			if (this.topOuterBound.compareTo(m.getLatitude()) < 0 )
				this.topOuterBound = m.getLatitude();
			
			else if (this.bottomOuterBound.compareTo(m.getLatitude()) < 0)
				this.bottomOuterBound = m.getLatitude();
			
			
		}
		}*/
	}
	
	public List<Mine> getMines() {
		return mines;
	}
	public void setMines(List<Mine> mines) {
		this.mines = mines;
	}
	public BigDecimal getLeftOuterBound() {
		return leftOuterBound;
	}
	public void setLeftOuterBound(BigDecimal leftOuterBound) {
		this.leftOuterBound = leftOuterBound;
	}
	public BigDecimal getRightOuterBound() {
		return rightOuterBound;
	}
	public void setRightOuterBound(BigDecimal rightOuterBound) {
		this.rightOuterBound = rightOuterBound;
	}
	public BigDecimal getTopOuterBound() {
		return topOuterBound;
	}
	public void setTopOuterBound(BigDecimal topOuterBound) {
		this.topOuterBound = topOuterBound;
	}
	public BigDecimal getBottomOuterBound() {
		return bottomOuterBound;
	}
	public void setBottomOuterBound(BigDecimal bottomOuterBound) {
		this.bottomOuterBound = bottomOuterBound;
	}

	public BigDecimal getMiddleLat() {
		return middleLat;
	}

	public void setMiddleLat(BigDecimal middleLat) {
		this.middleLat = middleLat;
	}

	public BigDecimal getMiddleLong() {
		return middleLong;
	}

	public void setMiddleLong(BigDecimal middleLong) {
		this.middleLong = middleLong;
	}
	
  
}
