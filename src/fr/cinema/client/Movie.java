package fr.cinema.client;

public class Movie 
{
    private String id;
    private String title;
    private String duration;
    private String director;
    //Values "VO" or "VF"
    private String language;
    //Values "EN" or "FR" ou null
    private String subtitles;
    private String mainActors;
    
    public Movie()
    {
    	
    }
    
	public Movie(String id, String title, String duration, String director, String language, String subtitles, String mainActors)
	{
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.director = director;
		this.language = language;
		this.subtitles = subtitles;
		this.mainActors = mainActors;
	}

	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getDuration() 
	{
		return duration;
	}
	
	public void setDuration(String duration) 
	{
		this.duration = duration;
	}
	
	public String getDirector() 
	{
		return director;
	}
	
	public void setDirector(String director) 
	{
		this.director = director;
	}
	
	public String getLanguage() 
	{
		return language;
	}
	
	public void setLanguage(String language) 
	{
		this.language = language;
	}
	
	public String getSubtitles() 
	{
		return subtitles;
	}
	
	public void setSubtitles(String subtitles) 
	{
		this.subtitles = subtitles;
	}
	
	public String getMainActors() 
	{
		return mainActors;
	}
	
	public void setMainActors(String mainActors) 
	{
		this.mainActors = mainActors;
	}
    
    
}