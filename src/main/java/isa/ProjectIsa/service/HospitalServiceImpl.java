package isa.ProjectIsa.service;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.ProjectIsa.model.Hospital;
import isa.ProjectIsa.repository.HospitalRepositoryImpl;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
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
	
	private SSHClient setupSshj() throws IOException {
	    SSHClient client = new SSHClient();
	    client.addHostKeyVerifier(new PromiscuousVerifier());
	    client.connect("192.168.100.4", 22);
	    client.authPassword("tester", "password");
	    return client;
	}
	
	public void whenDownloadFileUsingSshj_thenSuccess() throws IOException {
	    SSHClient sshClient = setupSshj();
	    SFTPClient sftpClient = sshClient.newSFTPClient();
	    String localDir = "src/main/resources/";
	 
	    sftpClient.get("SavedList.txt", localDir + "SavedList.txt");
	 
	    sftpClient.close();
	    sshClient.disconnect();
	}

}
