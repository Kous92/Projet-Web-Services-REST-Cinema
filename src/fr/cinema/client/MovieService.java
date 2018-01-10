package fr.cinema.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import fr.cinema.client.Movie;
import fr.cinema.client.MovieManager;

public class MovieService 
{
	@Context
    UriInfo uriInfo;
    @Context
    Request request; 
    String id;
    
    public MovieService(UriInfo uriInfo, Request request, String id) 
    {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    // Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Movie getMovie() 
    {
        Movie movie = MovieManager.instance.getModel().get(id);
        
        if (movie == null) 
        {
            throw new RuntimeException("GET: Movie avec " + id +  " introuvable");
        }
        
        return movie;
    }
    
    // Pour le navigateur
    @GET
    @Produces(MediaType.TEXT_XML)
    public Movie getMovieHTML() 
    {    
    		Movie movie = MovieManager.instance.getModel().get(id);
        
        if (movie == null) 
        {
            throw new RuntimeException("GET: Movie avec " + id +  " introuvable");
        }
        
        return movie;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putMovie(JAXBElement<Movie> movie) 
    {
        Movie m = movie.getValue();
        return putAndGetResponse(m);
    }

    @DELETE
    public void deleteMovie()
    {
        Movie c = MovieManager.instance.getModel().remove(id);
        
        if (c == null)
        {
        		throw new RuntimeException("DELETE: User avec " + id + " introuvable");
        }       
    }

    private Response putAndGetResponse(Movie movie) 
    {
        Response res;
        
        if (UserManager.instance.getModel().containsKey(movie.getId())) 
        {
            res = Response.noContent().build();
        } 
        else 
        {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        
        MovieManager.instance.getModel().put(movie.getId(), movie);
        
        return res;
    }
}
