package fr.cinema.client;

import java.io.*;
import java.util.*;
import fr.cinema.client.Movie;

public enum MovieManager 
{
	instance;

    private Map<String, Movie> contentProvider = new HashMap<>();

    private MovieManager() 
    {
		 Movie movie = new Movie("1", "Suicid Squad", "2h03", "David Ayer", "Anglais", "Français", "Will Smith");
         contentProvider.put("1", movie);
        
   	  	 movie = new Movie("2", "The Dark Knight Rises", "2h44", "Christopher Nolan", "Anglais", "Français", "Christian Bale");
         contentProvider.put("2", movie);
   	  	 
   	  	 movie = new Movie("3", "Fast & Furious 7", "2h17", "James Wan", "Anglais", "Français", "Vin Diesel");
         contentProvider.put("3", movie);
    }
    
    public Map<String, Movie> getModel()
    {
        return contentProvider;
    }
}