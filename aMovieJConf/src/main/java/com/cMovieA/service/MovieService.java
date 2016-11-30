package com.cMovieA.service;

import java.util.List;

import com.cMovieA.entity.Movie;

public interface MovieService {

	public List<Movie> getMovies();

	public void saveMovie(Movie theMovie);

	public List<Movie> getMovieById(int theId);

	public List<Movie> getMovieByTitle(String theTitle);

	public List<Movie> getMovieByDirector(String theDirector);

	public List<Movie> getMovieByYear(int theYear);

	public void deleteMovieById(int theId);

	public void deleteMovieByTitle(String theTitle);

	public void deleteMovieByDirector(String theDirector);

	public void deleteMovieByYear(int theYear);

}
