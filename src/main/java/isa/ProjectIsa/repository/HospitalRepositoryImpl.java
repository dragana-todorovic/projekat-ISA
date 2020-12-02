package isa.ProjectIsa.repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import isa.ProjectIsa.model.Hospital;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository{

	private final ConcurrentMap<UUID, Hospital> hospitals = new ConcurrentHashMap<UUID, Hospital>();
	@Override
	public Hospital registerHospital(Hospital hospital) {
		UUID id = hospital.getHospitalAPIkey();
		if (id == null) {
			id = UUID.randomUUID();
			hospital.setHospitalAPIkey(id);
		}
		this.hospitals.put(id, hospital);
		return hospital;
	}

	
	
	
}
