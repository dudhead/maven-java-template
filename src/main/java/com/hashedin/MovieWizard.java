/**
 * 
 */
package com.hashedin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hasher
 *
 */
public class MovieWizard {
	Map<Integer, Movie> movieMap;
	Map<Integer, User> userMap;
	Map<Integer, Rating> ratingMap;
	Map<Integer, List<Integer>> genreMap;

	public MovieWizard(Map<Integer, Movie> movieMap,
			Map<Integer, List<Integer>> genreMap, Map<Integer, User> userMap,
			Map<Integer, Rating> ratingMap) {
		this.movieMap = movieMap;
		this.userMap = userMap;
		this.ratingMap = ratingMap;
		this.genreMap = genreMap;
	}

	public User getMostActiveUser() {
		int maxLength = 0;
		int userId = 0;
		for (User user : userMap.values()) {
			if (user.getRatingIds().size() > maxLength) {
				maxLength = user.getRatingIds().size();
				userId = user.getId();
			}
		}
		return userMap.get(userId);
	}

	public Movie getMostWatchedMovie() {
		int maxLength = 0;
		int id = 0;
		for (Movie movie : movieMap.values()) {
			if (movie.getRatingIds().size() > maxLength) {
				maxLength = movie.getRatingIds().size();
				id = movie.getId();
			}
		}
		return movieMap.get(id);
	}

	public Movie getTopMovieByGenre(int genreId) {
		List<Integer> filteredData = filterMoviesByGenre(movieMap, genreId);
		double max=0;
		int id=0;
		for (Integer movieId : filteredData) {
			if(movieMap.get(movieId).getAvgRating()>max){
				max=movieMap.get(movieId).getAvgRating();
				id=movieMap.get(movieId).getId();
			}
		}

		return movieMap.get(id);
	}

	public Movie getTopMovieByYear(int year){
		
	}
	// public List<Movie> filterMovieByGenre(List<Movie>,)

	private List<Integer> filterMoviesByGenre(Map<Integer, Movie> initialData,
			int genreName) {

		List<Integer> movieIds = genreMap.get(genreName);
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer movieId : movieIds) {
			filteredList.add(movieId);
		}
		return filteredList;
	}
	
	private List<Integer> filterMoviesByYear(Map<Integer, Movie> initialData,
			int year){
		
	}

}