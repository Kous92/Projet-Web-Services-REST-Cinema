package fr.cinema.client;

import java.util.*;
import fr.cinema.client.Screening;
import fr.cinema.client.Movie;
import fr.cinema.client.MovieManager;

public enum ScreeningManager 
{
	instance;

    private Map<String, Screening> contentProvider = new HashMap<>();

    private ScreeningManager() 
    {
    		 List<Movie> movies = new ArrayList<Movie>();
         movies.addAll(MovieManager.instance.getModel().values());
         int n = 1;
         String city1 = "Paris";
         String city2 = "Lyon";
         String city3 = "Nice";
         
         for (int i = 0; i < movies.size(); i++)
         {	 
        	 	 Movie movie = movies.get(i);
        	 	 Screening screening = new Screening(city1, movie.getTitle(), Integer.toString(n), "13/12/2017", "17/12/2017", 10, "13h00", "16h00", "19h00");
             contentProvider.put(Integer.toString(n), screening);
             
             n++;
             screening = new Screening(city2, movie.getTitle(), Integer.toString(n), "13/12/2017", "17/12/2017", 10, "13h00", "16h00", "19h00");
             contentProvider.put(Integer.toString(n), screening);
       	  	 
             n++;
             screening = new Screening(city3, movie.getTitle(), Integer.toString(n), "13/12/2017", "17/12/2017", 10, "13h00", "16h00", "19h00");
             contentProvider.put(Integer.toString(n), screening);
             
             n++;
         }
    }
    
    public Map<String, Screening> getModel()
    {
        return contentProvider;
    }
}
