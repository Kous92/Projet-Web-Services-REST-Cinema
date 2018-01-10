package fr.cinema.client;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

public class Screening 
{
    private String ville;
    private int filmId;
    private int cinemaId;
    private Date startDate;
    private Date endDate;
    private int minimumAge;
    
    //3 weekly screenings for each movie, example: "Wednesday, 15:00"
    private String firstScreening;

    public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getFilmId() 
    {
        return filmId;
    }

    public void setFilmId(int filmId) 
    {
        this.filmId = filmId;
    }

    public int getCinemaId() 
    {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) 
    {
        this.cinemaId = cinemaId;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public String getFirstScreening() {
        return firstScreening;
    }

    public void setFirstScreening(String firstScreening) {
        this.firstScreening = firstScreening;
    }

    public String getSecondScreening() {
        return secondScreening;
    }

    public void setSecondScreening(String secondScreening) {
        this.secondScreening = secondScreening;
    }

    public String getThirdScreening() {
        return thirdScreening;
    }

    public void setThirdScreening(String thirdScreening) {
        this.thirdScreening = thirdScreening;
    }
    private String secondScreening;
    private String thirdScreening;
}
