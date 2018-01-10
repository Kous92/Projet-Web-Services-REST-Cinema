package fr.cinema.client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Screening 
{
    private String city;
    private String movieTitle;
    private String cinemaId;
    private String startDate;
    private String endDate;
    private int minimumAge;
    
    //3 weekly screenings for each movie, example: "Wednesday, 15:00"
    private String firstScreening;
    private String secondScreening;
    private String thirdScreening;
    
    public Screening()
    {
    	
    }
    
    public Screening(String city, String movieTitle, String cinemaId, String startDate, String endDate, int minimumAge,
			String firstScreening, String secondScreening, String thirdScreening) 
    {
		this.city = city;
		this.movieTitle = movieTitle;
		this.cinemaId = cinemaId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minimumAge = minimumAge;
		this.firstScreening = firstScreening;
		this.secondScreening = secondScreening;
		this.thirdScreening = thirdScreening;
	}

	public String getCity() 
    {
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getMovieTitle() 
    {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) 
    {
        this.movieTitle = movieTitle;
    }

    public String getCinemaId() 
    {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) 
    {
        this.cinemaId = cinemaId;
    }

    public String getStartDate() 
    {
        return startDate;
    }

    public void setStartDate(String startDate) 
    {
        this.startDate = startDate;
    }

    public String getEndDate() 
    {
        return endDate;
    }

    public void setEndDate(String endDate) 
    {
        this.endDate = endDate;
    }

    public int getMinimumAge()
    {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) 
    {
        this.minimumAge = minimumAge;
    }

    public String getFirstScreening() 
    {
        return firstScreening;
    }

    public void setFirstScreening(String firstScreening) 
    {
        this.firstScreening = firstScreening;
    }

    public String getSecondScreening() 
    {
        return secondScreening;
    }

    public void setSecondScreening(String secondScreening) 
    {
        this.secondScreening = secondScreening;
    }

    public String getThirdScreening() 
    {
        return thirdScreening;
    }

    public void setThirdScreening(String thirdScreening) 
    {
        this.thirdScreening = thirdScreening;
    }
}
