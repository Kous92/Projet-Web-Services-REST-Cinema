package fr.cinema.client;

import java.io.*;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import fr.cinema.client.User;
import fr.cinema.client.UserManager;

//Will map the resource to the URL users
@Path("/users")
public class UserServices 
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
    public List<User> getUsersBrowser() 
    {
        List<User> users = new ArrayList<User>();
        users.addAll(UserManager.instance.getModel().values());
        
        return users;
    }

    // Return the list of Users for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<User> getUsers() 
    {
        List<User> users = new ArrayList<User>();
        users.addAll(UserManager.instance.getModel().values());
        
        return users;
    }

    // Retourne le nombre d'utilisateurs
    // Use http://localhost:8080/http://localhost:8080/WebServicesProjectCinema.User/rest/users/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() 
    {
        int count = UserManager.instance.getModel().size();
        return "Nombre d'utilisateurs enregistrés: " + String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newUser(@FormParam("id") String id, @FormParam("email") String email, @FormParam("password") String password,
    		@FormParam("identity") String identity, @Context HttpServletResponse servletResponse) throws IOException 
    {
       
    		if ((email.equals(email)) && (password.equals(password)))
    		{
    			
    		}
        
        servletResponse.sendRedirect("../users.html");
    }

    // Defines that the next path parameter after Users is
    // treated as a parameter and passed to the UserServices
    // Allows to type http://localhost:8080/WebServiceProjectCinema/rest/users/1
    // 1 will be treaded as parameter User and passed to UserService
    @Path("{user}")
    public UserService getUser(@PathParam("user") String id) 
    {
        return new UserService(uriInfo, request, id);
    }
}
