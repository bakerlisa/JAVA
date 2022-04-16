package com.codingdojo.lookfyTwo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.lookfyTwo.models.Song;
import com.codingdojo.lookfyTwo.services.SongService;

@Controller
public class HomeController {
	
	@Autowired
	SongService songService;
	
	//	PAGE - splash page
	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	//	PAGE - dash
	@GetMapping("/dashboard")
	public String dash(Model model) {
		List<Song> song = songService.allSongs();
		model.addAttribute("song", song);
		return "dashboard.jsp";
	}
	
	// PAGE - song
	@GetMapping("/add/song")
	public String addSong(Model model, @ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	// ADDING - new song
	@PostMapping("/api/add/song")
	public String addSongForm(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	// PAGE - edit song
	@GetMapping("/edit/{id}")
	public String editSong(Model model, @PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "editSong.jsp";
	}
	
	// EDIT - song
	@PostMapping("/api/edit/song")
	public String editSongForm(Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "editSong.jsp";
		}else {
			songService.editSong(song);
			return "redirect:/dashboard";
		}
	}
	
	// PAGE - single song
	@GetMapping("/song/{id}")
	public String singleSong(Model model, @PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "song.jsp";
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	//PAGE - topTen
	@GetMapping("/topTen")
	public String topTen(Model model) {
		List<Song> song = songService.getTopTen(7);
		model.addAttribute("song",song);
		return "topTen.jsp";
	}
	
	// FORM - search
	@PostMapping("/api/search")
	public String search(Model model,@Valid @RequestParam("search") String search, RedirectAttributes redirectAttributes) {
		System.out.println(search);
		if(search.length() > 0) {
			List<Song> song = songService.findSearch(search);
			model.addAttribute("artist", search);
			model.addAttribute("song", song);
		}else {
			redirectAttributes.addFlashAttribute("error", "You need to add a Query!");
			return "redirect:/dashboard";
		}
		return "search.jsp";
	}
	
	
	
}
