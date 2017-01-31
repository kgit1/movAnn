package com.cMovieA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cMovieA.entity.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getMovies() {
		Session session = sessionFactory.getCurrentSession();

		List<Movie> movies = session.createCriteria(Movie.class).list();
		// hibernate 5
		// Query<Movie> theQuery = session.createQuery("from Movie",
		// Movie.class);
		// List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public void saveMovie(Movie theMovie) {
		Session session = sessionFactory.getCurrentSession();

		session.save(theMovie);
	}

	@Override
	public List<Movie> getMovieById(int theId) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> movies = session.createQuery("from Movie where id=" + theId).list();
		// hibernate 5
		// Query<Movie> theQuery = session
		// .createQuery("from Movie where id=" + theId, Movie.class);
		// List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public List<Movie> getMovieByTitle(String theTitle) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> movies = session.createQuery("from Movie where title='" + theTitle + "'").list();
		// hibernate 5
		// Query<Movie> theQuery = session.createQuery(
		// "from Movie where title='" + theTitle + "'", Movie.class);
		// List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public List<Movie> getMovieByDirector(String theDirector) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> movies = session.createQuery("from Movie where director='" + theDirector + "'").list();
		// hibernate 5
		// Query<Movie> theQuery = session.createQuery(
		// "from Movie where director='" + theDirector + "'", Movie.class);
		// List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public List<Movie> getMovieByYear(int theYear) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> movies = session.createQuery("from Movie where year=" + theYear).list();
		// hibernate 5
		// Query<Movie> theQuery = session
		// .createQuery("from Movie where year=" + theYear, Movie.class);
		// List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public void deleteMovieById(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Movie where id=:movieId");
		theQuery.setParameter("movieId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public void deleteMovieByTitle(String theTitle) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> list = session.createQuery("from Movie where title=" + theTitle).list();
		// hibernate5
		// Query<Movie> theQuery = session
		// .createQuery("from Movie where title=:movieTitle", Movie.class);
		// theQuery.setParameter("movieTitle", theTitle);
		// List<Movie> list = theQuery.getResultList();

		for (Movie movie : list) {
			deleteMovieById(movie.getId());
		}
	}

	@Override
	public void deleteMovieByDirector(String theDirector) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> list = session.createQuery("from Movie where director=" + theDirector).list();
		// hibernate5
		// Query<Movie> theQuery = session.createQuery(
		// "from Movie where director=:movieDirector", Movie.class);
		// theQuery.setParameter("movieDirector", theDirector);
		// List<Movie> list = theQuery.getResultList();

		for (Movie movie : list) {
			deleteMovieById(movie.getId());
		}
	}

	@Override
	public void deleteMovieByYear(int theYear) {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> list = session.createQuery("from Movie where year=" + theYear).list();
		// hibernate5
		// Query<Movie> theQuery = session
		// .createQuery("from Movie where year=:movieYear", Movie.class);
		// theQuery.setParameter("movieYear", theYear);
		// List<Movie> list = theQuery.getResultList();

		for (Movie movie : list) {
			deleteMovieById(movie.getId());
		}
	}
}
