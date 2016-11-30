package com.cMovieA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cMovieA.DAO.MovieDAO;
import com.cMovieA.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public void saveMovie(Movie theMovie) {
		movieDAO.saveMovie(theMovie);
	}

	@Override
	@Transactional
	public List<Movie> getMovieById(int theId) {
		return movieDAO.getMovieById(theId);
	}

	@Override
	@Transactional
	public List<Movie> getMovieByTitle(String theTitle) {
		return movieDAO.getMovieByTitle(theTitle);
	}

	@Override
	@Transactional
	public List<Movie> getMovieByDirector(String theDirector) {
		return movieDAO.getMovieByDirector(theDirector);
	}

	@Override
	@Transactional
	public List<Movie> getMovieByYear(int theYear) {
		return movieDAO.getMovieByYear(theYear);
	}

	@Override
	@Transactional
	public void deleteMovieById(int theId) {
		movieDAO.deleteMovieById(theId);

	}

	@Override
	@Transactional
	public void deleteMovieByTitle(String theTitle) {
		movieDAO.deleteMovieByTitle(theTitle);

	}

	@Override
	@Transactional
	public void deleteMovieByDirector(String theDirector) {
		movieDAO.deleteMovieByDirector(theDirector);

	}

	@Override
	@Transactional
	public void deleteMovieByYear(int theYear) {
		movieDAO.deleteMovieByYear(theYear);

	}

}
