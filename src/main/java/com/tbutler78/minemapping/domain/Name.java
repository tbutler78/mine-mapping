package com.tbutler78.minemapping.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="names")
public class Name implements Serializable{

	private static final long serialVersionUID = -8551478845763476317L;

	@Id
	private long id;
	private String sequenceNumber;
	@Column(name="SeparatedNames_Deposit_FieldName")
	private String separatedNamesDepositFieldName;
	private String nameKey;
	@Column(name="R_Index2_Deposit_FieldName")
	private String rIndexDepositFieldName;
	private long metric;
	private long autoNumber;
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
	public String getSeparatedNamesDepositFieldName() {
		return separatedNamesDepositFieldName;
	}
	public void setSeparatedNamesDepositFieldName(
			String separatedNamesDepositFieldName) {
		this.separatedNamesDepositFieldName = separatedNamesDepositFieldName;
	}
	public String getNameKey() {
		return nameKey;
	}
	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}
	public String getrIndexDepositFieldName() {
		return rIndexDepositFieldName;
	}
	public void setrIndexDepositFieldName(String rIndexDepositFieldName) {
		this.rIndexDepositFieldName = rIndexDepositFieldName;
	}
	public long getMetric() {
		return metric;
	}
	public void setMetric(long metric) {
		this.metric = metric;
	}
	public long getAutoNumber() {
		return autoNumber;
	}
	public void setAutoNumber(long autoNumber) {
		this.autoNumber = autoNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Name [id=" + id + ", sequenceNumber=" + sequenceNumber
				+ ", separatedNamesDepositFieldName="
				+ separatedNamesDepositFieldName + ", nameKey=" + nameKey
				+ ", rIndexDepositFieldName=" + rIndexDepositFieldName
				+ ", metric=" + metric + ", autoNumber=" + autoNumber + "]";
	}
	
	
}
