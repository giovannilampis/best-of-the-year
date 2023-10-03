package org.java.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NameController {
	
	@GetMapping("/best")
	public String best(Model model) {
		final String name = "GIOVANNI";
		
		model.addAttribute("name", name);
		
		return "best";
	}
	
	@GetMapping("/movies")
	public String getMoviesIndex(Model model) {
		
		String strMovies = getMovies().stream()

								.map(Movie::getTitle)
							.collect(Collectors.joining(", "));
				
		model.addAttribute("strMovies", strMovies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongsIndex(Model model) {
		
		String strSongs = getSongs().stream()
								.map(Song::getTitle)
							.collect(Collectors.joining(", "));
		
		model.addAttribute("strSongs", strSongs);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieDetails(@PathVariable int id, Model model) {
		
		Movie movie = getMovies().stream()
							.filter(m -> m.getId() == id)
						.findFirst().get();
		String movieTitle = movie.getTitle();
		
		model.addAttribute("movieTitle", movieTitle);
		
		return "movie-details";
	}
	@GetMapping("/songs/{id}")
	public String getSongDetails(@PathVariable int id, Model model) {
		
		Song song = getSongs().get(id);
		String songTitle = song.getTitle();
		
		model.addAttribute("songTitle", songTitle);
		
		return "song-details";
	}
	
	private List<Movie> getMovies() {
		
		return Arrays.asList(new Movie[] {
				new Movie(1, "movie 1"),
				new Movie(2, "movie 2"),
				new Movie(3, "movie 3"),
				new Movie(4, "movie 4"),
				new Movie(5, "movie 5")
		});
	}
	private List<Song> getSongs() {
		
		return Arrays.asList(new Song[] {
				new Song(1, "song 1"),
				new Song(2, "song 2"),
				new Song(3, "song 3"),
				new Song(4, "song 4"),
				new Song(5, "song 5")
		});
	}
		
}
