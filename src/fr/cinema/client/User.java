package fr.cinema.client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User 
{
	private String id;
	private String email;
	private String password;
	private String identity;
	
	public User()
	{
		
	}
	
	public User(String id, String email, String password)
	{
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getIdentity() 
	{
		return identity;
	}

	public void setIdentity(String identity) 
	{
		this.identity = identity;
	}	
}
