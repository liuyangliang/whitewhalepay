package com.scut.whitewhalepay.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transtype", schema = "whitewhalepay", catalog = "")
public class TransType {
	private int transTypeId;
	private String transType;
	
	@Id
    @Column(name = "TransTypeId")
	public int getTransTypeId() {
		return transTypeId;
	}
	public void setTransTypeId(int transTypeId) {
		this.transTypeId = transTypeId;
	}
	
	@Basic
    @Column(name = "TransType")
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transType == null) ? 0 : transType.hashCode());
		result = prime * result + transTypeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransType other = (TransType) obj;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		if (transTypeId != other.transTypeId)
			return false;
		return true;
	}
	
	
}
