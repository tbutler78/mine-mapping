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
	private SortedSet<BigDecimal> latitudeRange;
	private SortedSet<BigDecimal> longitudeRange;
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
		this.middleLat.subtract(topOuterBound);
		this.middleLat.divide(new BigDecimal(2));
		this.middleLat.add(topOuterBound);
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


/*
	interface Functor<T,F extends Functor<?,?>> {
		<R> F map(Function<T,R> f);
	}

	class Identity<T> implements Functor<T,Identity<?>> {

		private final T value;

		Identity(T value) { this.value = value; }

		public <R> Identity<R> map(Function<T,R> f) {
			final R result = f.apply(value);
			return new Identity<>(result);
		}

	}

	Identity<String> idString = new Identity<>("abc");
	Identity<Integer> idInt = idString.map(String::length);

*/
	Mine mine;
	/*Identity<byte[]> idBytes = new Identity<>(mine)
			.map(Mine::getCountyName)
			//.map(Mine::getDmsLat)
			.map((String s) -> s.substring(0, 3))
			.map(String::toLowerCase)
			.map(String::getBytes);
*/
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
