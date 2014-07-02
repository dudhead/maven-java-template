package com.hashedin;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		MovieManager movieManager = new MovieManager();
		UserManager userManager = new UserManager();

		InputStream userData = movieManager.getClass().getClassLoader()
				.getResourceAsStream("user.data");
		InputStream movieData = movieManager.getClass().getClassLoader()
				.getResourceAsStream("movie.data");
		InputStream ratingsData = movieManager.getClass().getClassLoader()
				.getResourceAsStream("ratings.data");

		userManager.storeUsers(userData);
		movieManager.storeMovie(movieData);
		RatingsManager ratingsManager = new RatingsManager(userManager,
				movieManager);
		ratingsManager.storeRatings(ratingsData);
		
		

	}
	
}
