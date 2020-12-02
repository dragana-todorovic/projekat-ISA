package isa.ProjectIsa.service;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import isa.ProjectIsa.model.Hospital;

public interface HospitalService {
	Hospital registerHospital(Hospital hospital) throws Exception;
	Hospital findById(UUID id);

	Collection<Hospital> findAll();
	void whenDownloadFileUsingSshj_thenSuccess() throws IOException ;
}
