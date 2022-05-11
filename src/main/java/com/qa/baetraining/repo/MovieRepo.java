package com.qa.baetraining.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.baetraining.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	@Query(value = "SELECT * FROM movie WHERE movie_title = ?", nativeQuery = true)
	Movie findMovie(String movieTitle);
	
	@Query(value = "SELECT * FROM movie WHERE release_year = ?", nativeQuery = true)
	public List<Movie> findByYear(int releaseYear);
	
	@Query(value = "SELECT * FROM movie WHERE rating = ?", nativeQuery = true)
	public List<Movie> findByRating(int rating);
	
	@Query(value = "SELECT * FROM movie WHERE seen = true", nativeQuery = true)
	public List<Movie> findBySeen(boolean seen);
	
	@Query(value = "SELECT * FROM movie WHERE seen = false", nativeQuery = true)
	public List<Movie> findByUnSeen(boolean seen);

} 
