package org.java.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class NameController {

	@GetMapping("/")
	@ResponseBody
	public String name() {
		final String myName = "GIOVANNI";
		return "Best of the year by ..." + myName;
	}
	
	@GetMapping("/best")
	public String best(Model model) {
		final String name = "GIOVANNI";
		
		model.addAttribute("name", name);
		
		return "best";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
		List<Movie> movies = getBestMovies();
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		List<Song> songs = getBestSongs();
		
		((Object) model).addAttribute("songs", songs);
		
		return "songs";
	}
		
}
