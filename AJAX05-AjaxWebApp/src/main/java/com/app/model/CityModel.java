package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city_master")
public class CityModel 
{
	@Id
	@GeneratedValue
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "state_id")
	private int stateId;
	
	@Column(name = "city_name")
	private String cityName;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "CityModel [cityId=" + cityId + ", stateId=" + stateId + ", cityName=" + cityName + "]";
	}
	
	

}
