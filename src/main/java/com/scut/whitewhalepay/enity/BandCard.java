package com.scut.whitewhalepay.enity;

import javax.persistence.*;

@Entity
@Table(name = "bandcard", schema = "whitewhalepay", catalog = "")
public class BandCard {
	private String UwId;
	private String BankCardNo;
	private String BankInfo;
	
	 @Id
	 @Column(name = "UwId")
	public String getUwId() {
		return UwId;
	}
	 
	public void setUwId(String uwId) {
		UwId = uwId;
	}
	
	@Basic
    @Column(name = "BankCardNo")
	public String getBankCardNo() {
		return BankCardNo;
	}
	
	public void setBankCardNo(String bankCardNo) {
		BankCardNo = bankCardNo;
	}
	
	@Basic
    @Column(name = "BankInfo")
	public String getBankInfo() {
		return BankInfo;
	}
	public void setBankInfo(String bankInfo) {
		BankInfo = bankInfo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BankCardNo == null) ? 0 : BankCardNo.hashCode());
		result = prime * result + ((BankInfo == null) ? 0 : BankInfo.hashCode());
		result = prime * result + ((UwId == null) ? 0 : UwId.hashCode());
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
		BandCard other = (BandCard) obj;
		if (BankCardNo == null) {
			if (other.BankCardNo != null)
				return false;
		} else if (!BankCardNo.equals(other.BankCardNo))
			return false;
		if (BankInfo == null) {
			if (other.BankInfo != null)
				return false;
		} else if (!BankInfo.equals(other.BankInfo))
			return false;
		if (UwId == null) {
			if (other.UwId != null)
				return false;
		} else if (!UwId.equals(other.UwId))
			return false;
		return true;
	}
	
	
}
