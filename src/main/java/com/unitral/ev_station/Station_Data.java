package com.unitral.ev_station;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Station_Data {
	@Id
	@Column(name="station_id")
	int stationId;
	String name=null;
	@Column(name="stationImage")
	String stationImage=null;
	@Column(name="station_pricing")
	int stationPricing;
	@Column(name="station_address")
	String stationAddress=null;
	public Station_Data(int station_id, String station_name, String station_image, int station_pricing,
			String station_address) {
		super();
		this.stationId = (int) station_id;
		this.name = station_name;
		this.stationImage = station_image;
		this.stationPricing = station_pricing;
		this.stationAddress = station_address;
	}

	Station_Data(){
		
	}
	
	

	public long getStation_id() {
		return stationId;
	}
	public void setStation_id(int station_id) {
		this.stationId = station_id;
	}
	public String getStation_name() {
		return name;
	}
	public void setStation_name(String station_name) {
		this.name = station_name;
	}
	public String getStation_image() {
		return stationImage;
	}
	public void setStation_image(String station_image) {
		this.stationImage = station_image;
	}
	public int getStation_pricing() {
		return stationPricing;
	}
	public void setStation_pricing(int station_pricing) {
		this.stationPricing = station_pricing;
	}
	public String getStation_address() {
		return stationAddress;
	}
	public void setStation_address(String station_address) {
		this.stationAddress = station_address;
	}
	
	

}
