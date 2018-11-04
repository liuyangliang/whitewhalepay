package com.scut.whitewhalepay.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "underwriter", schema = "whitewhalepay", catalog = "")
public class Underwriter {
	private String uwId;
	private String uwName;
	private String loginSecret;
	private String uwUsdtAct;
	private String uwIdentNo;
	private String uwPhone;
	private String uwIdCardPic1;
	private String uwIdCardPic2;
	private String uwAliPayName;
	private String uwAliPayQrCode;
	private String uwAliPayPic;
	
	@Id
	@Column(name = "UwId")
	public String getUwId() {
		return uwId;
	}
	public void setUwId(String uwId) {
		this.uwId = uwId;
	}
	
	@Basic
    @Column(name = "UwName")
	public String getUwName() {
		return uwName;
	}
	public void setUwName(String uwName) {
		this.uwName = uwName;
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
    @Column(name = "UwUsdtAct")
	public String getUwUsdtAct() {
		return uwUsdtAct;
	}
	public void setUwUsdtAct(String uwUsdtAct) {
		this.uwUsdtAct = uwUsdtAct;
	}
	
	@Basic
    @Column(name = "UwIdentNo")
	public String getUwIdentNo() {
		return uwIdentNo;
	}
	public void setUwIdentNo(String uwIdentNo) {
		this.uwIdentNo = uwIdentNo;
	}
	
	@Basic
    @Column(name = "UwPhone")
	public String getUwPhone() {
		return uwPhone;
	}
	public void setUwPhone(String uwPhone) {
		this.uwPhone = uwPhone;
	}
	
	@Basic
    @Column(name = "UwIdCardPic1")
	public String getUwIdCardPic1() {
		return uwIdCardPic1;
	}
	public void setUwIdCardPic1(String uwIdCardPic1) {
		this.uwIdCardPic1 = uwIdCardPic1;
	}
	
	@Basic
    @Column(name = "UwIdCardPic2")
	public String getUwIdCardPic2() {
		return uwIdCardPic2;
	}
	public void setUwIdCardPic2(String uwIdCardPic2) {
		this.uwIdCardPic2 = uwIdCardPic2;
	}
	
	@Basic
    @Column(name = "UwAliPayName")
	public String getUwAliPayName() {
		return uwAliPayName;
	}
	public void setUwAliPayName(String uwAliPayName) {
		this.uwAliPayName = uwAliPayName;
	}
	
	@Basic
    @Column(name = "UwAliPayQrCode")
	public String getUwAliPayQrCode() {
		return uwAliPayQrCode;
	}
	public void setUwAliPayQrCode(String uwAliPayQrCode) {
		this.uwAliPayQrCode = uwAliPayQrCode;
	}
	
	@Basic
    @Column(name = "UwAliPayPic")
	public String getUwAliPayPic() {
		return uwAliPayPic;
	}
	public void setUwAliPayPic(String uwAliPayPic) {
		this.uwAliPayPic = uwAliPayPic;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginSecret == null) ? 0 : loginSecret.hashCode());
		result = prime * result + ((uwAliPayName == null) ? 0 : uwAliPayName.hashCode());
		result = prime * result + ((uwAliPayPic == null) ? 0 : uwAliPayPic.hashCode());
		result = prime * result + ((uwAliPayQrCode == null) ? 0 : uwAliPayQrCode.hashCode());
		result = prime * result + ((uwId == null) ? 0 : uwId.hashCode());
		result = prime * result + ((uwIdCardPic1 == null) ? 0 : uwIdCardPic1.hashCode());
		result = prime * result + ((uwIdCardPic2 == null) ? 0 : uwIdCardPic2.hashCode());
		result = prime * result + ((uwIdentNo == null) ? 0 : uwIdentNo.hashCode());
		result = prime * result + ((uwName == null) ? 0 : uwName.hashCode());
		result = prime * result + ((uwPhone == null) ? 0 : uwPhone.hashCode());
		result = prime * result + ((uwUsdtAct == null) ? 0 : uwUsdtAct.hashCode());
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
		Underwriter other = (Underwriter) obj;
		if (loginSecret == null) {
			if (other.loginSecret != null)
				return false;
		} else if (!loginSecret.equals(other.loginSecret))
			return false;
		if (uwAliPayName == null) {
			if (other.uwAliPayName != null)
				return false;
		} else if (!uwAliPayName.equals(other.uwAliPayName))
			return false;
		if (uwAliPayPic == null) {
			if (other.uwAliPayPic != null)
				return false;
		} else if (!uwAliPayPic.equals(other.uwAliPayPic))
			return false;
		if (uwAliPayQrCode == null) {
			if (other.uwAliPayQrCode != null)
				return false;
		} else if (!uwAliPayQrCode.equals(other.uwAliPayQrCode))
			return false;
		if (uwId == null) {
			if (other.uwId != null)
				return false;
		} else if (!uwId.equals(other.uwId))
			return false;
		if (uwIdCardPic1 == null) {
			if (other.uwIdCardPic1 != null)
				return false;
		} else if (!uwIdCardPic1.equals(other.uwIdCardPic1))
			return false;
		if (uwIdCardPic2 == null) {
			if (other.uwIdCardPic2 != null)
				return false;
		} else if (!uwIdCardPic2.equals(other.uwIdCardPic2))
			return false;
		if (uwIdentNo == null) {
			if (other.uwIdentNo != null)
				return false;
		} else if (!uwIdentNo.equals(other.uwIdentNo))
			return false;
		if (uwName == null) {
			if (other.uwName != null)
				return false;
		} else if (!uwName.equals(other.uwName))
			return false;
		if (uwPhone == null) {
			if (other.uwPhone != null)
				return false;
		} else if (!uwPhone.equals(other.uwPhone))
			return false;
		if (uwUsdtAct == null) {
			if (other.uwUsdtAct != null)
				return false;
		} else if (!uwUsdtAct.equals(other.uwUsdtAct))
			return false;
		return true;
	}
	
	
}
