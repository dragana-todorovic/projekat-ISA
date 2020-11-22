package isa.ProjectIsa.model;

import java.util.UUID;

public class Hospital {
	private String name;
	private UUID hospitalAPIkey;
	
	public Hospital() {
		super();
	}
	public Hospital(String name, UUID hospitalAPIkey) {
		super();
		this.name = name;
		this.hospitalAPIkey = hospitalAPIkey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UUID getHospitalAPIkey() {
		return hospitalAPIkey;
	}
	public void setHospitalAPIkey(UUID hospitalAPIkey) {
		this.hospitalAPIkey = hospitalAPIkey;
	}
	
	
}
