package com.tbutler78.minemapping.web;

import com.tbutler78.minemapping.domain.Mine;

import java.math.BigDecimal;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class MineCommand {
	private List<Mine> mines;
	private BigDecimal leftOuterBound = new BigDecimal(0);
	private BigDecimal rightOuterBound = new BigDecimal(0);
	private BigDecimal topOuterBound = new BigDecimal(0);
	private BigDecimal bottomOuterBound = new BigDecimal(0);

	private BigDecimal middleLat;
	private BigDecimal middleLong;

	public MineCommand(List<Mine> mines){

		this.mines = mines;
		SortedSet<BigDecimal> latitudeRange = new TreeSet<>();
		SortedSet<BigDecimal> longitudeRange = new TreeSet<>();
		for (Mine m : mines){

			latitudeRange.add(m.getLatitude());
			longitudeRange.add(m.getLongitude());
		}


		this.leftOuterBound = longitudeRange.first();
		this.rightOuterBound = longitudeRange.last();
		this.topOuterBound = latitudeRange.first();
		this.bottomOuterBound = latitudeRange.last();
		this.middleLat = bottomOuterBound;
		this.middleLat = middleLat.subtract(topOuterBound).divide(new BigDecimal(2)).add(topOuterBound);
		this.middleLong = leftOuterBound.subtract(rightOuterBound).divide(new BigDecimal(2)).add(rightOuterBound) ;

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
