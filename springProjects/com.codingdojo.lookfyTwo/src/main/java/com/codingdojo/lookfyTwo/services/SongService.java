package com.codingdojo.lookfyTwo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookfyTwo.models.Song;
import com.codingdojo.lookfyTwo.repositories.SongRepository;


@Service
public class SongService {
	private final SongRepository songRepo;
	
	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSongs(){
		return songRepo.findAll();
	}
	
	public Song createSong(Song song) {
		return songRepo.save(song);
	}
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepo.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
        
    }
	
	public Song editSong(Song song) {
		Optional<Song> optionalSong = songRepo.findById(song.getId());
    	
    	if(optionalSong.isPresent()) {
    		
    		Song thisSong = optionalSong.get();
            
    		thisSong.setTitle(song.getTitle());
    		thisSong.setArtist(song.getArtist());
    		thisSong.setRating(song.getRating());
    	
            return songRepo.save(thisSong);
        } else {
            return null;
        }
	}
	
	public List<Song> getTopTen(int rating){
		return songRepo.findByRatingGreaterThanOrderByRatingDesc(rating);
	}
	
	public List<Song> findSearch(String search){
		return songRepo.findByArtistContaining(search);
	}
}
