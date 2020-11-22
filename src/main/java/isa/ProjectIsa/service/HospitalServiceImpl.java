package isa.ProjectIsa.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.ProjectIsa.model.Hospital;
import isa.ProjectIsa.repository.HospitalRepositoryImpl;
@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepositoryImpl hospitalRepository;
	
	@Override
	public Hospital registerHospital(Hospital hospital) throws Exception {
		 if (hospital.getHospitalAPIkey() != null) {
	            throw new Exception(
	                    "Id mora biti null prilikom perzistencije novog entiteta.");
	        }
	     Hospital savedHospital = hospitalRepository.registerHospital(hospital);
	     return savedHospital;

	}

	@Override
	public Collection<Hospital> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital findById(UUID id) {
		
		return new Hospital("jankovic hospital", UUID.randomUUID());
	}

}
