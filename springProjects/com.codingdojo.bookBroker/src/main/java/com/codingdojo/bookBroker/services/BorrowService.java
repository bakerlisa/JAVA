package com.codingdojo.bookBroker.services;

import org.springframework.stereotype.Service;

import com.codingdojo.bookBroker.repositories.BorrowRepository;

@Service
public class BorrowService {
	public final BorrowRepository borrRepo;
	
	public BorrowService(BorrowRepository borrRepo) {
		this.borrRepo = borrRepo;
	}
}
