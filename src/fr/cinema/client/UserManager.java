package fr.cinema.client;

import java.security.*;
import java.util.*;
import fr.cinema.client.User;

public enum UserManager
{
	instance;

    private Map<String, User> contentProvider = new HashMap<>();

    private UserManager() 
    {
    		 try
    		 {
    			 MessageDigest md = MessageDigest.getInstance("MD5");
				 
    			 User user = new User("1", "koussaila.ben.mamar@efrei.net", "koussaila");
    	         user.setIdentity("Koussaïla BEN MAMAR");
    	         
    	         md.update(user.getPassword().getBytes());
    			 byte[] digest = md.digest();
    			 
    			 StringBuffer sb = new StringBuffer();
    			
    			 for (byte b : digest) 
    			 {
    				 sb.append(String.format("%02x", b & 0xff));
    			 }
    			 
    			 user.setPassword(sb.toString());
    	         contentProvider.put("1", user);

    	         user = new User("2", "arthur.schickel@efrei.net", "arthur");
    	         user.setIdentity("Arthur SCHICKEL");
    	         
    	         md.update(user.getPassword().getBytes());
    			 digest = md.digest();
    			 
    			 sb = new StringBuffer();
    			
    			 for (byte b : digest) 
    			 {
    				 sb.append(String.format("%02x", b & 0xff));
    			 }
    			 
    			 user.setPassword(sb.toString());
    	         contentProvider.put("2", user);
    	         
    	         user = new User("3", "ibrahim.el.karrat@efrei.net", "ibrahim");
    	         user.setIdentity("IBRAHIM EL KARRAT");
    	         
    	         md.update(user.getPassword().getBytes());
    			 digest = md.digest();
    			 
    			 sb = new StringBuffer();
    			
    			 for (byte b : digest) 
    			 {
    				 sb.append(String.format("%02x", b & 0xff));
    			 }
    			 
    			 user.setPassword(sb.toString());
    	         contentProvider.put("3", user);
    		 }
    		 catch(NoSuchAlgorithmException e)
    		 {
    			 
    		 }
    }
    
    public Map<String, User> getModel()
    {
        return contentProvider;
    }
}
