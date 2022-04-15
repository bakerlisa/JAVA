package com.codingdojo.language.services;

import java.util.List;

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
}
