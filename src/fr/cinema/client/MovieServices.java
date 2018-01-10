package fr.cinema.client;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import fr.cinema.client.Movie;
import fr.cinema.client.MovieManager;

//Will map the resource to the URL movies
@Path("/movies")
public class MovieServices 
{

	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Return the list of Users to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Movie> getMoviesBrowser() 
    {
        List<Movie> movies = new ArrayList<Movie>();
        movies.addAll(MovieManager.instance.getModel().values());
        
        return movies;
    }

    // Return the list of Movies for applications (XML display)
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Movie> getMovies() 
    {
    		List<Movie> movies = new ArrayList<Movie>();
        movies.addAll(MovieManager.instance.getModel().values());
        
        return movies;
    }

    // Retourne le nombre de films
    // Use http://localhost:8080/WebServicesProjectCinema.Movies/rest/movies/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() 
    {
        int count = MovieManager.instance.getModel().size();
        return "Nombre de films dans la base: " + String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newMovie(@FormParam("id") String id, @FormParam("title") String title, @FormParam("duration") String duration, @FormParam("director") String director,
    		@FormParam("language") String language, @FormParam("subtitles") String subtitles, @FormParam("mainActors") String mainActors
    		,@Context HttpServletResponse servletResponse) throws IOException 
    {
        Movie movie = new Movie(id, title, duration, director, language, subtitles, mainActors);
        MovieManager.instance.getModel().put(id, movie);
        
        servletResponse.sendRedirect("../movies.html");
    }

    // Defines that the next path parameter after Users is
    // treated as a parameter and passed to the UserServices
    // Allows to type http://localhost:8080/com.vogella.jersey.User/rest/users/1
    // 1 will be treaded as parameter User and passed to UserService
    @Path("{movie}")
    public MovieService getMovie(@PathParam("movie") String id) 
    {
        return new MovieService(uriInfo, request, id);
    }
}