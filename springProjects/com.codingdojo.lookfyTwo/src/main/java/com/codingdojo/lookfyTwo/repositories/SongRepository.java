package com.codingdojo.lookfyTwo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookfyTwo.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();

	// List<Song> OrderByRatingDesc();
	// List<Song> findTopByOrderByRatingDesc();
	// List<Song> findByRatingGreaterThan(int rating);
//	List<Song> findTop3OrderByRatingDesc(int rating);
//	List<Song> findTop3findByRatingGreaterThanOrderByRatingDesc(int rating);
	 List<Song> findByRatingGreaterThanOrderByRatingDesc(int rating);
	 

	
	 // List<Song> findByArtistLike(String artist);
	 // List<Song> findByArtistStartingWith(String search);
	 List<Song> findByArtistContaining(String search);
	
	
	
	
}
