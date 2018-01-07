package fr.cinema.client;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import javax.xml.bind.JAXBElement;

import fr.cinema.client.User;
import fr.cinema.client.UserManager;

public class UserService 
{
	@Context
    UriInfo uriInfo;
    @Context
    Request request; 
    String id;
    
    public UserService(UriInfo uriInfo, Request request, String id) 
    {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    // Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getUser() 
    {
        User user = UserManager.instance.getModel().get(id);
        
        if (user == null) 
        {
            throw new RuntimeException("Get: User avec " + id +  " introuvable");
        }
        
        return user;
    }
    
    // Pour le navigateur
    @GET
    @Produces(MediaType.TEXT_XML)
    public User getUserHTML() 
    {    
    		User user = UserManager.instance.getModel().get(id);
        
        if (user==null) 
        {
            throw new RuntimeException("GET: User avec " + id +  " introuvable");
        }
        
        return user;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putUser(JAXBElement<User> user) 
    {
        User u = user.getValue();
        return putAndGetResponse(u);
    }

    @DELETE
    public void deleteUser()
    {
        User c = UserManager.instance.getModel().remove(id);
        
        if (c == null)
        {
        		throw new RuntimeException("DELETE: User avec " + id + " introuvable");
        }       
    }

    private Response putAndGetResponse(User user) 
    {
        Response res;
        
        if (UserManager.instance.getModel().containsKey(user.getId())) 
        {
            res = Response.noContent().build();
        } 
        else 
        {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        
        UserManager.instance.getModel().put(user.getId(), user);
        
        return res;
    }
}