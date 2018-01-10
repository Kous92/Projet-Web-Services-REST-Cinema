package fr.cinema.client;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import fr.cinema.client.Screening;
import fr.cinema.client.ScreeningManager;

//Will map the resource to the URL screenings
@Path("/screenings")
public class ScreeningServices 
{
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Return the list of Screening to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Screening> getMoviesBrowser() 
    {
    		List<Screening> screenings = new ArrayList<Screening>();
    		screenings.addAll(ScreeningManager.instance.getModel().values());   
        return screenings;
    }

    // Return the list of Movies for applications (XML display)
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Screening> getScreenings() 
    {
    		List<Screening> screenings = new ArrayList<Screening>();
		screenings.addAll(ScreeningManager.instance.getModel().values());  
		
		return screenings;
    }

    // Retourne le nombre de séances
    // Use http://localhost:8080/WebServicesProjectCinema/rest/screenings/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() 
    {
        int count = ScreeningManager.instance.getModel().size();
        return "Nombre de séances dans la base: " + String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newScreening(@FormParam("city") String city, @FormParam("movie_title") String movieTitle, @FormParam("id") String cinemaId, @FormParam("start_date") String startDate,
    		@FormParam("end_date") String endDate, @FormParam("minimum_age") int minimumAge, @FormParam("first_screening") String firstScreening
    		,@FormParam("second_screening") String secondScreening, @FormParam("third_screening") String thirdScreening, @Context HttpServletResponse servletResponse) throws IOException 
    {
    		Screening screening = new Screening(city, movieTitle, cinemaId, startDate, endDate, minimumAge, firstScreening, secondScreening, thirdScreening);
        
        if (city != null)
        {
        		screening.setCity(city);
        }
        
        if (movieTitle != null)
        {
        		screening.setMovieTitle(movieTitle);
        }
        
        if (cinemaId != null)
        {
        		screening.setCinemaId(cinemaId);
        }
        
        if (startDate != null)
        {
        		screening.setStartDate(startDate);
        }
        	
        if (endDate != null)
        {
        		screening.setEndDate(endDate);
        }
        
        	screening.setMinimumAge(minimumAge);
        
        ScreeningManager.instance.getModel().put(cinemaId, screening);
        
        servletResponse.sendRedirect("../screenings.html");
    }

    // Defines that the next path parameter after Users is
    // treated as a parameter and passed to the UserServices
    // Allows to type http://localhost:8080/ProjectWebServices/rest/movies/1
    // 1 will be treaded as parameter User and passed to UserService
    @Path("{screening}")
    public ScreeningService getMovie(@PathParam("screening") String id) 
    {
        return new ScreeningService(uriInfo, request, id);
    }
}
