package com.codingdojo.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language language) {
		return langRepo.save(language);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
	
	public Language updateNewLanguage(Language language) {
		Optional<Language> optionalLanguage = langRepo.findById(language.getId());
		
		if(optionalLanguage.isPresent()) {
			System.out.println(language.getId());
			Language thisLanguage = optionalLanguage.get();
			
			thisLanguage.setName(language.getName());
			thisLanguage.setCreator(language.getCreator());
			thisLanguage.setVersion(language.getVersion());
			
			return langRepo.save(thisLanguage);
		}else{
			return null;
		}
	}
	
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}
}
