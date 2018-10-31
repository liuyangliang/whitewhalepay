package com.scut.whitewhalepay.enity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transstate", schema = "whitewhalepay", catalog = "")
public class TransState {
	private int transStateId;
	private String transState;
	
	@Id
    @Column(name = "TransStateId")
	public int getTransStateId() {
		return transStateId;
	}
	public void setTransStateId(int transStateId) {
		this.transStateId = transStateId;
	}
	
	@Basic
    @Column(name = "TransState")
	public String getTransState() {
		return transState;
	}
	public void setTransState(String transState) {
		this.transState = transState;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transState == null) ? 0 : transState.hashCode());
		result = prime * result + transStateId;
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
		TransState other = (TransState) obj;
		if (transState == null) {
			if (other.transState != null)
				return false;
		} else if (!transState.equals(other.transState))
			return false;
		if (transStateId != other.transStateId)
			return false;
		return true;
	}
	
	
}
