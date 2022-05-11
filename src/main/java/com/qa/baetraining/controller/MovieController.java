package com.qa.baetraining.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baetraining.domain.Movie;
import com.qa.baetraining.service.MovieService;

@CrossOrigin
@RequestMapping
@RestController
public class MovieController {
	
	public MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Movie> getById(@PathVariable long id) {
		return new ResponseEntity<Movie>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/findMovie/{movieTitle}")
	public ResponseEntity<Movie> findMovie(@PathVariable String movieTitle) {
		return new ResponseEntity<Movie>(service.findMovie(movieTitle), HttpStatus.OK);
	}
	
	@GetMapping("/allMovies")
	public ResponseEntity<List<Movie>> allMovies() {
		return new ResponseEntity<List<Movie>>(service.allMovies(), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/addMovie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(service.addMovie(movie), 		HttpStatus.RESET_CONTENT); 
	}
	
	@PutMapping("/updateMovie/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie) {
		return new ResponseEntity<Movie>(service.updateMovie(id, movie), HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id) { //question mark means it can be anything; ResponseEntity is a generic so it has to take in some sort of parameter 
		return (service.deleteById(id))? new ResponseEntity<>(HttpStatus.OK) :
		new ResponseEntity<>(service.deleteById(id), HttpStatus.INTERNAL_SERVER_ERROR); //GIVES TWO POSSIBLE RESPONSE CODES
	}
	
	@GetMapping("/findByYear/{releaseYear}")
	public ResponseEntity<List<Movie>> findByYear(@PathVariable int releaseYear){
		return new ResponseEntity<List<Movie>>(service.findByYear(releaseYear), HttpStatus.OK);
	}
	
	@GetMapping("/findByRating/{rating}")
	public ResponseEntity<List<Movie>> findByRating(@PathVariable int rating){
		return new ResponseEntity<List<Movie>>(service.findByRating(rating), HttpStatus.OK);
	}
	
		@GetMapping("/allMovies/findBySeen") //need one for true and one for false 
	public List<Movie> findBySeen(boolean seen){
		return service.findBySeen(seen);
	}
		@GetMapping("/allMovies/Unseen") //need one for true and one for false 
	public List<Movie> findByUnSeen(boolean seen){
		return service.findByUnSeen(seen);
	}
	//@PutMapping("/updateSeen/{id}")
		//public ResponseEntity<Movie> updateSeen(@PathVariable long id) {
		//	return new ResponseEntity<Movie>(service.updateSeen(id), HttpStatus.OK); 
	//}

}








