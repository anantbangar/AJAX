package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state_master")
public class StateModel 
{
	@Id
	@GeneratedValue
	@Column(name = "state_id")
	private int stateId;
	
	@Column(name = "country_id")
	private int countryId;
	
	@Column(name = "state_name")
	private String stateName;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "StateModel [stateId=" + stateId + ", countryId=" + countryId + ", stateName=" + stateName + "]";
	}
	
	
	
	
}
