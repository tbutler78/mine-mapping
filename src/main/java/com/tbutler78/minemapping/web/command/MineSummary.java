package com.tbutler78.minemapping.web.command;

import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.domain.PropertyFileScan;
import com.tbutler78.minemapping.domain.Reference;

import java.util.List;

/**
 * Created by butlert on 4/19/17.
 */
public class MineSummary {
	private Mine mine;
	private List<PropertyFileScan> propertyFileScans;
	private List<Reference> references;

	public MineSummary(Mine mine, List<PropertyFileScan> propertyFileScans, List<Reference> references) {
		this.mine = mine;
		this.propertyFileScans = propertyFileScans;
		this.references = references;
	}

	public Mine getMine() {
		return mine;
	}

	public void setMine(Mine mine) {
		this.mine = mine;
	}

	public List<PropertyFileScan> getPropertyFileScans() {
		return propertyFileScans;
	}

	public void setPropertyFileScans(List<PropertyFileScan> propertyFileScans) {
		this.propertyFileScans = propertyFileScans;
	}

	public List<Reference> getReferences() {
		return references;
	}

	public void setReferences(List<Reference> references) {
		this.references = references;
	}
}
