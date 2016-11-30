package com.cMovieA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cMovieA.entity.Movie;
import com.cMovieA.service.MovieService;

@Controller
@RequestMapping("movies")
public class HomeController {

	@Autowired
	private MovieService movieService;

	// @GetMapping("/list")
	// public String listMovies() {
	//
	// return "welcome";
	// }

	@GetMapping("/list")
	public String listMovies(Model theModel) {

		List<Movie> theMovies = movieService.getMovies();

		theModel.addAttribute("movies", theMovies);

		return "list-movies";
	}

	@GetMapping("/showFormMovies")
	public String showFormMovies(Model theModel) {
		Movie theMovie = new Movie();
		theModel.addAttribute("movie", theMovie);
		return "form-movies";
	}

	@GetMapping("/showMovie")
	public String showMovieByTitle(
			// @RequestParam("id") int theYear,
			Model theModel) {
		List<Movie> theMovies = movieService.getMovieByYear(1920);
		theModel.addAttribute("movie1", theMovies);
		return "form-movie";
	}

	@GetMapping("/showMovieById")
	public String showMovieById(@RequestParam("id") int theId, Model theModel) {
		List<Movie> theMovies = movieService.getMovieById(theId);
		theModel.addAttribute("movie1", theMovies);
		return "form-movie";
	}

	@GetMapping("/showMovieByTitle")
	public String showMovieByTitle(@RequestParam("title") String theTitle,
			Model theModel) {
		List<Movie> theMovies = movieService.getMovieByTitle(theTitle);
		theModel.addAttribute("movie1", theMovies);
		return "form-movie";
	}

	@GetMapping("/showMovieByDirector")
	public String showMovieByDirector(
			@RequestParam("director") String theDirector, Model theModel) {
		List<Movie> theMovies = movieService.getMovieByDirector(theDirector);
		theModel.addAttribute("movie1", theMovies);
		return "form-movie";
	}

	@GetMapping("/showMovieByYear")
	public String showMovieByTitle1(@RequestParam("year") int theYear,
			Model theModel) {
		List<Movie> theMovies = movieService.getMovieByYear(theYear);
		theModel.addAttribute("movie1", theMovies);
		return "form-movie";
	}

	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie theMovie) {
		movieService.saveMovie(theMovie);
		return "redirect:/movies/list";
	}

	@GetMapping("/deleteMovieById")
	public String deleteMovieById(@RequestParam("id") int theId) {
		movieService.deleteMovieById(theId);
		return "redirect:/movies/list";
	}

	@GetMapping("/deleteMovieByTitle")
	public String deleteMovieByTitle(@RequestParam("title") String theTitle) {
		movieService.deleteMovieByTitle(theTitle);
		return "redirect:/movies/list";
	}

	@GetMapping("/deleteMovieByDirector")
	public String deleteMovieByDirector(
			@RequestParam("director") String theDirector) {
		movieService.deleteMovieByDirector(theDirector);
		return "redirect:/movies/list";
	}

	@GetMapping("/deleteMovieByYear")
	public String deleteMovieByYear(@RequestParam("year") int theYear) {
		movieService.deleteMovieByYear(theYear);
		return "redirect:/movies/list";
	}

}
