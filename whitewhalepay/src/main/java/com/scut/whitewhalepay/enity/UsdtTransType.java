package com.scut.whitewhalepay.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usdttranstype", schema = "whitewhalepay", catalog = "")
public class UsdtTransType {
	private int usdtTransTypeId;
	private String usdtTransType;
	
	@Id
    @Column(name = "UsdtTransTypeId")
	public int getUsdtTransTypeId() {
		return usdtTransTypeId;
	}
	public void setUsdtTransTypeId(int usdtTransTypeId) {
		this.usdtTransTypeId = usdtTransTypeId;
	}
	
	@Basic
    @Column(name = "UsdtTransType")
	public String getUsdtTransType() {
		return usdtTransType;
	}
	public void setUsdtTransType(String usdtTransType) {
		this.usdtTransType = usdtTransType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usdtTransType == null) ? 0 : usdtTransType.hashCode());
		result = prime * result + usdtTransTypeId;
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
		UsdtTransType other = (UsdtTransType) obj;
		if (usdtTransType == null) {
			if (other.usdtTransType != null)
				return false;
		} else if (!usdtTransType.equals(other.usdtTransType))
			return false;
		if (usdtTransTypeId != other.usdtTransTypeId)
			return false;
		return true;
	}
	
	
}
