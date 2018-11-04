package com.scut.whitewhalepay.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "margin", schema = "whitewhalepay", catalog = "")
public class Margin {
	private String uwId;
	private int amount;

	@Id
	@Column(name = "UwId")
	public String getUwId() {
		return uwId;
	}

	public void setUwId(String uwId) {
		this.uwId = uwId;
	}
	
	@Basic
    @Column(name = "Amount")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
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
		Margin other = (Margin) obj;
		if (amount != other.amount)
			return false;
		if (uwId == null) {
			if (other.uwId != null)
				return false;
		} else if (!uwId.equals(other.uwId))
			return false;
		return true;
	}

}
