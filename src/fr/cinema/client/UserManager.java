package fr.cinema.client;

import java.util.*;
import fr.cinema.client.User;

public enum UserManager 
{
	instance;

    private Map<String, User> contentProvider = new HashMap<>();

    private UserManager() 
    {
        User user = new User("1", "koussaila.ben.mamar@efrei.net", "koussaila");
        user.setIdentity("Koussaïla BEN MAMAR");
        contentProvider.put("1", user);
        
        user = new User("2", "arthur.schickel@efrei.net", "arthur");
        user.setIdentity("Arthur SCHICKEL");
        contentProvider.put("2", user);
        
        user = new User("3", "ibrahim.el.karrat@efrei.net", "ibrahim");
        user.setIdentity("IBRAHIM EL KARRAT");
        contentProvider.put("3", user);
    }
    
    public Map<String, User> getModel()
    {
        return contentProvider;
    }
}
