package com.codingdojo.exam.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.exam.models.Item;
import com.codingdojo.exam.repositories.ItemRepository;

public class ItemService {
	private final ItemRepository itemRepo;
	
	public ItemService(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	public List<Item> allItems(){
		return itemRepo.findAll();
	}
	
	public Item createItem(Item item) {
		return itemRepo.save(item);
	}
	
	public void deleteItem(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Item singleItem(Long id) {
		Optional<Item> optItem = itemRepo.findById(id);
		if(optItem.isPresent()) {
			return optItem.get();
		}else {
			return null;
		}
	}
	
	public Item editItem(Item item) {
		Optional<Item> optItem = itemRepo.findById(item.getId());
		if(optItem.isPresent()) {
			Item thisItem = optItem.get();
			
			thisItem.setAuthor(item.getAuthor());
			thisItem.setTitle(item.getTitle());
			thisItem.setReview(item.getReview());
			thisItem.setId(item.getId());
			
			return optItem.save(thisItem);
		}else {
			return null;
		}
	}
}
