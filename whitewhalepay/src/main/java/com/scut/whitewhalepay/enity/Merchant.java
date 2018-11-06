package com.scut.whitewhalepay.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant", schema = "whitewhalepay", catalog = "")
public class Merchant {
	private String mctId;
	private String mctName;
	private String loginSecret;
	private String mctUsdtAct;
	private String mctPhone;
	private String mctIdentNo;
	private String mctIdCardPic1;
	private String mctIdCardPic2;
	
	@Id
	@Column(name = "MctId")
	public String getMctId() {
		return mctId;
	}
	public void setMctId(String mctId) {
		this.mctId = mctId;
	}
	
	@Basic
    @Column(name = "MctName")
	public String getMctName() {
		return mctName;
	}
	public void setMctName(String mctName) {
		this.mctName = mctName;
	}
	
	@Basic
    @Column(name = "LoginSecret")
	public String getLoginSecret() {
		return loginSecret;
	}
	public void setLoginSecret(String loginSecret) {
		this.loginSecret = loginSecret;
	}
	
	@Basic
    @Column(name = "MctUsdtAct")
	public String getMctUsdtAct() {
		return mctUsdtAct;
	}
	public void setMctUsdtAct(String mctUsdtAct) {
		this.mctUsdtAct = mctUsdtAct;
	}
	
	@Basic
    @Column(name = "MctPhone")
	public String getMctPhone() {
		return mctPhone;
	}
	public void setMctPhone(String mctPhone) {
		this.mctPhone = mctPhone;
	}
	
	@Basic
    @Column(name = "MctIdentNo")
	public String getMctIdentNo() {
		return mctIdentNo;
	}
	public void setMctIdentNo(String mctIdentNo) {
		this.mctIdentNo = mctIdentNo;
	}
	
	@Basic
    @Column(name = "MctIdCardPic1")
	public String getMctIdCardPic1() {
		return mctIdCardPic1;
	}
	public void setMctIdCardPic1(String mctIdCardPic1) {
		this.mctIdCardPic1 = mctIdCardPic1;
	}
	
	@Basic
    @Column(name = "MctIdCardPic2")
	public String getMctIdCardPic2() {
		return mctIdCardPic2;
	}
	public void setMctIdCardPic2(String mctIdCardPic2) {
		this.mctIdCardPic2 = mctIdCardPic2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginSecret == null) ? 0 : loginSecret.hashCode());
		result = prime * result + ((mctId == null) ? 0 : mctId.hashCode());
		result = prime * result + ((mctIdCardPic1 == null) ? 0 : mctIdCardPic1.hashCode());
		result = prime * result + ((mctIdCardPic2 == null) ? 0 : mctIdCardPic2.hashCode());
		result = prime * result + ((mctIdentNo == null) ? 0 : mctIdentNo.hashCode());
		result = prime * result + ((mctPhone == null) ? 0 : mctPhone.hashCode());
		result = prime * result + ((mctUsdtAct == null) ? 0 : mctUsdtAct.hashCode());
		result = prime * result + ((mctName == null) ? 0 : mctName.hashCode());
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
		Merchant other = (Merchant) obj;
		if (loginSecret == null) {
			if (other.loginSecret != null)
				return false;
		} else if (!loginSecret.equals(other.loginSecret))
			return false;
		if (mctId == null) {
			if (other.mctId != null)
				return false;
		} else if (!mctId.equals(other.mctId))
			return false;
		if (mctIdCardPic1 == null) {
			if (other.mctIdCardPic1 != null)
				return false;
		} else if (!mctIdCardPic1.equals(other.mctIdCardPic1))
			return false;
		if (mctIdCardPic2 == null) {
			if (other.mctIdCardPic2 != null)
				return false;
		} else if (!mctIdCardPic2.equals(other.mctIdCardPic2))
			return false;
		if (mctIdentNo == null) {
			if (other.mctIdentNo != null)
				return false;
		} else if (!mctIdentNo.equals(other.mctIdentNo))
			return false;
		if (mctPhone == null) {
			if (other.mctPhone != null)
				return false;
		} else if (!mctPhone.equals(other.mctPhone))
			return false;
		if (mctUsdtAct == null) {
			if (other.mctUsdtAct != null)
				return false;
		} else if (!mctUsdtAct.equals(other.mctUsdtAct))
			return false;
		if (mctName == null) {
			if (other.mctName != null)
				return false;
		} else if (!mctName.equals(other.mctName))
			return false;
		return true;
	}
	
	
}
