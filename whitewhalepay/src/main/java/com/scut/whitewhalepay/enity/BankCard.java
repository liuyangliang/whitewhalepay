package com.scut.whitewhalepay.enity;

import javax.persistence.*;

@Entity
@Table(name = "bankcard", schema = "whitewhalepay", catalog = "")
public class BankCard {
	private String uwId;
	private String bankCardNo;
	private String bankInfo;

	@Id
	@Column(name = "BankCardNo")
	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
	@Basic
	@Column(name = "UwId")
	public String getUwId() {
		return uwId;
	}

	public void setUwId(String uwId) {
		this.uwId = uwId;
	}

	

	@Basic
	@Column(name = "BankInfo")
	public String getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCardNo == null) ? 0 : bankCardNo.hashCode());
		result = prime * result + ((bankInfo == null) ? 0 : bankInfo.hashCode());
		result = prime * result + ((uwId == null) ? 0 : uwId.hashCode());
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
		BankCard other = (BankCard) obj;
		if (bankCardNo == null) {
			if (other.bankCardNo != null)
				return false;
		} else if (!bankCardNo.equals(other.bankCardNo))
			return false;
		if (bankInfo == null) {
			if (other.bankInfo != null)
				return false;
		} else if (!bankInfo.equals(other.bankInfo))
			return false;
		if (uwId == null) {
			if (other.uwId != null)
				return false;
		} else if (!uwId.equals(other.uwId))
			return false;
		return true;
	}

}
