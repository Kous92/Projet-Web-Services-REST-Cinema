package fr.cinema.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class MovieClient 
{
	public static void main(String[] args)
	{
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    WebTarget service = client.target(getBaseURI());

	    // Créer un film (User)
	    Movie movie = new Movie("1", "Suicid Squad", "2h03", "David Ayer", "Anglais", "Français", "Will Smith");
	    Response response = service.path("rest").path("movie").path(movie.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(movie,MediaType.APPLICATION_XML),Response.class);

	    // Return code should be 201 == created resource
	    System.out.println(response.getStatus());
	    
	    // Get the users
	    System.out.println(service.path("rest").path("movies").request().accept(MediaType.TEXT_XML).get(String.class));

 	   	// Get JSON for application (Make sure to add the jersey-media-json-jackson dependency to add support for JSON)
        // System.out.println(service.path("rest").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class));

	    // Get XML for application
	    	System.out.println(service.path("rest").path("movies").request().accept(MediaType.APPLICATION_XML).get(String.class));

	    //Get User with id 1
	    Response checkDelete = service.path("rest").path("movies/1").request().accept(MediaType.APPLICATION_XML).get();

	    // Delete User with id 1
	    service.path("rest").path("movies/1").request().delete();

	    //Get get all users id 1 should be deleted
	    System.out.println(service.path("rest").path("movies").request().accept(MediaType.APPLICATION_XML).get(String.class));

        //Create a User
        Form form = new Form();
        form.param("id", "karim.benzema@gmail.com");
        form.param("benzema","Karim BENZEMA");
        response = service.path("rest").path("movies").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED), Response.class);
        
        System.out.println("Form response " + response.getStatus());

        //Get all the movies, id 5 should have been created
	    System.out.println(service.path("rest").path("movies").request().accept(MediaType.APPLICATION_XML).get(String.class));

	  }

	  private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/WebServicesProjectCinema").build();
	  }
}
