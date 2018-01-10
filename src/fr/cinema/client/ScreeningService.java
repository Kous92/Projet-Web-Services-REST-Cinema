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

import fr.cinema.client.Screening;
import fr.cinema.client.ScreeningManager;

public class ScreeningService 
{
	@Context
    UriInfo uriInfo;
    @Context
    Request request; 
    String id;
    String city;
    
    public ScreeningService(UriInfo uriInfo, Request request, String id) 
    {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    // Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Screening getScreening() 
    {
        Screening screening = ScreeningManager.instance.getModel().get(id);
        
        if (screening == null) 
        {
            throw new RuntimeException("GET: Screening avec " + id +  " introuvable");
        }
        
        return screening;
    }
    
    // Pour le navigateur
    @GET
    @Produces(MediaType.TEXT_XML)
    public Screening getScreeningHTML() 
    {    
    		Screening screening = ScreeningManager.instance.getModel().get(id);
        
        if (screening == null) 
        {
            throw new RuntimeException("GET: Screening avec " + id +  " introuvable");
        }
        
        return screening;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putScreening(JAXBElement<Screening> screenings) 
    {
        Screening m = screenings.getValue();
        return putAndGetResponse(m);
    }

    @DELETE
    public void deleteScreening()
    {
        Screening c = ScreeningManager.instance.getModel().remove(id);
        
        if (c == null)
        {
        		throw new RuntimeException("DELETE: Screening avec " + id + " introuvable");
        }       
    }

    private Response putAndGetResponse(Screening screening) 
    {
        Response res;
        
        if (ScreeningManager.instance.getModel().containsKey(screening.getCinemaId())) 
        {
            res = Response.noContent().build();
        } 
        else 
        {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        
        ScreeningManager.instance.getModel().put(screening.getCinemaId(), screening);
        
        return res;
    }
}
