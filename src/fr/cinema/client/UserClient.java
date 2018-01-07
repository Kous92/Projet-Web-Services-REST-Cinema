package fr.cinema.client;

import javax.ws.rs.core.*;
import javax.ws.rs.client.*;
import fr.cinema.client.User;
import org.glassfish.jersey.client.ClientConfig;
import java.net.URI;

public class UserClient 
{
	public static void main(String[] args)
	{
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);
	    WebTarget service = client.target(getBaseURI());

	    // Créer un utilisateur (User)
	    User user = new User("4", "reda.bendraou@lip6.fr", "bendraou");
	    Response response = service.path("rest").path("users").path(user.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(user,MediaType.APPLICATION_XML),Response.class);

	    // Return code should be 201 == created resource
	    System.out.println(response.getStatus());
	    
	    // Get the users
	    System.out.println(service.path("rest").path("users").request().accept(MediaType.TEXT_XML).get(String.class));

 	   	// Get JSON for application (Make sure to add the jersey-media-json-jackson dependency to add support for JSON)
        // System.out.println(service.path("rest").path("users").request().accept(MediaType.APPLICATION_JSON).get(String.class));

	    // Get XML for application
	    	System.out.println(service.path("rest").path("users").request().accept(MediaType.APPLICATION_XML).get(String.class));

	    //Get User with id 1
	    Response checkDelete = service.path("rest").path("users/1").request().accept(MediaType.APPLICATION_XML).get();

	    // Delete User with id 1
	    service.path("rest").path("users/1").request().delete();

	    //Get get all users id 1 should be deleted
	    System.out.println(service.path("rest").path("users").request().accept(MediaType.APPLICATION_XML).get(String.class));

        //Create a User
        Form form = new Form();
        form.param("id", "karim.benzema@gmail.com");
        form.param("benzema","Karim BENZEMA");
        response = service.path("rest").path("users").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED), Response.class);
        
        System.out.println("Form response " + response.getStatus());

        //Get all the users, id 5 should have been created
	    System.out.println(service.path("rest").path("users").request().accept(MediaType.APPLICATION_XML).get(String.class));

	  }

	  private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/WebServicesProjectCinema").build();
	  }
}
