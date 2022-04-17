package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public List<License> allLicenses(){
		return licenseRepo.findAll();
	}
	
	public License createLicense(License license) {
		return licenseRepo.save(license);
	}
	
	
//	find one person
	public License findLicense(Long id) {
		Optional<License> optLicense = licenseRepo.findById(id);
		if(optLicense.isPresent()) {
			return optLicense.get();
		}else {			
			return null;
		}
	}
	
	public void deleteLicense(Long id) {
		licenseRepo.deleteById(id);
	}
	
}
