package com.scut.whitewhalepay.enity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions", schema = "whitewhalepay", catalog = "")
public class Transactions {
	private String transId;
	private int transType;
	private int usdtTransType;
	private int transState;
	private String reason;
	private String transBTime;
	private String transETime;
	private int transAmt;
	private int transUsdtAmt;
	private String mctId;
	private String uwId;
	private String uwUsdtAct;
	private String uwBankCard;
	private String transactionPic;
	private boolean uwConfirm;
	private String txId;
	@Id
	@Column(name = "TransId")
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	@Basic
    @Column(name = "TransType")
	public int getTransType() {
		return transType;
	}
	public void setTransType(int transType) {
		this.transType = transType;
	}
	
	@Basic
    @Column(name = "UsdtTransType")
	public int getUsdtTransType() {
		return usdtTransType;
	}
	public void setUsdtTransType(int usdtTransType) {
		this.usdtTransType = usdtTransType;
	}
	
	@Basic
    @Column(name = "TransState")
	public int getTransState() {
		return transState;
	}
	public void setTransState(int transState) {
		this.transState = transState;
	}
	
	@Basic
    @Column(name = "Reason")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Basic
    @Column(name = "TransBTime")
	public String getTransBTime() {
		return transBTime;
	}
	public void setTransBTime(String transBTime) {
		this.transBTime = transBTime;
	}
	
	@Basic
    @Column(name = "TransETime")
	public String getTransETime() {
		return transETime;
	}
	public void setTransETime(String transETime) {
		this.transETime = transETime;
	}
	
	@Basic
    @Column(name = "TransAmt")
	public int getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(int transAmt) {
		this.transAmt = transAmt;
	}
	
	@Basic
    @Column(name = "TransUsdtAmt")
	public int getTransUsdtAmt() {
		return transUsdtAmt;
	}
	public void setTransUsdtAmt(int transUsdtAmt) {
		this.transUsdtAmt = transUsdtAmt;
	}
	
	@Basic
    @Column(name = "MctId")
	public String getMctId() {
		return mctId;
	}
	public void setMctId(String mctId) {
		this.mctId = mctId;
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
    @Column(name = "UwUsdtAct")
	public String getUwUsdtAct() {
		return uwUsdtAct;
	}
	public void setUwUsdtAct(String uwUsdtAct) {
		this.uwUsdtAct = uwUsdtAct;
	}
	
	@Basic
    @Column(name = "UwBankCard")
	public String getUwBankCard() {
		return uwBankCard;
	}
	/**
	 * @return the transactionPic
	 */
	public String getTransactionPic() {
		return transactionPic;
	}
	/**
	 * @param transactionPic the transactionPic to set
	 */
	public void setTransactionPic(String transactionPic) {
		this.transactionPic = transactionPic;
	}
	/**
	 * @return the uwConfirm
	 */
	public boolean isUwConfirm() {
		return uwConfirm;
	}
	/**
	 * @param uwConfirm the uwConfirm to set
	 */
	public void setUwConfirm(boolean uwConfirm) {
		this.uwConfirm = uwConfirm;
	}
	/**
	 * @return the txId
	 */
	public String getTxId() {
		return txId;
	}
	/**
	 * @param txId the txId to set
	 */
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public void setUwBankCard(String uwBankCard) {
		this.uwBankCard = uwBankCard;
	}
	
	@Basic
    @Column(name = "transactionPic")
	public String gettransactionPic() {
		return transactionPic;
	}
	
	/**
	 * @param transactionPic the transactionPic to set
	 */
	public void settransactionPic(String transactionPic) {
		transactionPic = transactionPic;
	}
	/**
	 * @return the uwConfirm
	 */
	public boolean isuwConfirm() {
		return uwConfirm;
	}
	
	public void setuwConfirm(boolean uwConfirm) {
		this.uwConfirm = uwConfirm;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionPic == null) ? 0 : transactionPic.hashCode());
		result = prime * result + (uwConfirm ? 1231 : 1237);
		result = prime * result + ((mctId == null) ? 0 : mctId.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + transAmt;
		result = prime * result + ((transBTime == null) ? 0 : transBTime.hashCode());
		result = prime * result + ((transETime == null) ? 0 : transETime.hashCode());
		result = prime * result + ((transId == null) ? 0 : transId.hashCode());
		result = prime * result + transState;
		result = prime * result + transType;
		result = prime * result + transUsdtAmt;
		result = prime * result + usdtTransType;
		result = prime * result + ((uwBankCard == null) ? 0 : uwBankCard.hashCode());
		result = prime * result + ((uwId == null) ? 0 : uwId.hashCode());
		result = prime * result + ((uwUsdtAct == null) ? 0 : uwUsdtAct.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transactions other = (Transactions) obj;
		if (transactionPic == null) {
			if (other.transactionPic != null)
				return false;
		} else if (!transactionPic.equals(other.transactionPic))
			return false;
		if (uwConfirm != other.uwConfirm)
			return false;
		if (mctId == null) {
			if (other.mctId != null)
				return false;
		} else if (!mctId.equals(other.mctId))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (transAmt != other.transAmt)
			return false;
		if (transBTime == null) {
			if (other.transBTime != null)
				return false;
		} else if (!transBTime.equals(other.transBTime))
			return false;
		if (transETime == null) {
			if (other.transETime != null)
				return false;
		} else if (!transETime.equals(other.transETime))
			return false;
		if (transId == null) {
			if (other.transId != null)
				return false;
		} else if (!transId.equals(other.transId))
			return false;
		if (transState != other.transState)
			return false;
		if (transType != other.transType)
			return false;
		if (transUsdtAmt != other.transUsdtAmt)
			return false;
		if (usdtTransType != other.usdtTransType)
			return false;
		if (uwBankCard == null) {
			if (other.uwBankCard != null)
				return false;
		} else if (!uwBankCard.equals(other.uwBankCard))
			return false;
		if (uwId == null) {
			if (other.uwId != null)
				return false;
		} else if (!uwId.equals(other.uwId))
			return false;
		if (uwUsdtAct == null) {
			if (other.uwUsdtAct != null)
				return false;
		} else if (!uwUsdtAct.equals(other.uwUsdtAct))
			return false;
		return true;
	}
	
	

	
	
	
}
