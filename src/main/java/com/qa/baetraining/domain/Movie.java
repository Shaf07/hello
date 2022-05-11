package com.qa.baetraining.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "movieTitle", length = 50, nullable = false) //this overrides the default name for the column in the database and adds character limit
	private String movieTitle;
	
	@Column
	private int releaseYear;
	
	@Column
	int rating; //PRIVATE NO NO
	
	@Column(nullable = false)
	private boolean seen;
	
	
//-----
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}


	
//------
	
	public Movie() {
	}
	
	public Movie(String movieTitle, int releaseYear, int rating, boolean seen) {
		super();
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.seen = seen;
	}

	public Movie(long id, String movieTitle, int releaseYear, int rating, boolean seen) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.seen = seen;
	}
	
//---------
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieTitle=" + movieTitle + ", releaseYear=" + releaseYear + ", rating=" + rating
				+ ", seen=" + seen + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, movieTitle, rating, releaseYear, seen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id && Objects.equals(movieTitle, other.movieTitle) && rating == other.rating
				&& releaseYear == other.releaseYear && seen == other.seen;
	}

	 
}
