package fr.cinema.client;

import java.io.*;
import java.util.*;
import fr.cinema.client.User;

public enum UserManager 
{
	instance;

    private Map<String, User> contentProvider = new HashMap<>();
    private File fichier = new File("user_database.txt") ;
    private PrintWriter pw;
    private FileInputStream fis;
    private FileOutputStream fos;
    private byte[] bytesArray;
    private String str;

    private UserManager() 
    {
    		try 
    		{
    			 fis = new FileInputStream("user_database.txt"); // Lecture
    			 fos = new FileOutputStream(fichier); // Écriture
			
    			 if (!fichier.exists())
    			 {
    				 fichier.createNewFile();
    			 }
    			 
			 if (fichier.length() == 0)
			 {
				 System.out.println("Le fichier est vide, ajout de 3 utilisateurs par défaut"); 
				 
				 User user = new User("1", "koussaila.ben.mamar@efrei.net", "koussaila");
		         user.setIdentity("Koussaïla BEN MAMAR");
		         contentProvider.put("1", user);
		        
		         str = user.getId() + ":" + user.getEmail() + ":" + user.getPassword() + ":" + user.getIdentity();
		         bytesArray = str.getBytes();
		         fos.write(bytesArray);
		   	  	 fos.flush();
		         
		         user = new User("2", "arthur.schickel@efrei.net", "arthur");
		         user.setIdentity("Arthur SCHICKEL");
		         contentProvider.put("2", user);
		         
		         str = user.getId() + ":" + user.getEmail() + ":" + user.getPassword() + ":" + user.getIdentity();
		         bytesArray = str.getBytes();
		         fos.write(bytesArray);
		   	  	 fos.flush();
		         
		         user = new User("3", "ibrahim.el.karrat@efrei.net", "ibrahim");
		         user.setIdentity("IBRAHIM EL KARRAT");
		         contentProvider.put("3", user);
		         
		         str = user.getId() + ":" + user.getEmail() + ":" + user.getPassword() + ":" + user.getIdentity();
		         bytesArray = str.getBytes();
		         fos.write(bytesArray);
		   	  	 fos.flush();
		         
		         System.out.println("Fichier: " + fichier.length());
			 }
			 else
			 {
				 System.out.println("Le fichier n'est pas vide, lecture de la base de données...");
				 
				 int old_posn=0,posn=0;
			     
				 DataInputStream in = new DataInputStream(fis);
		         BufferedReader br = new BufferedReader(new InputStreamReader(in));
		         String strLine = "";
		 
		         while ((strLine = br.readLine()) != null) 
		         {
		        	 	System.out.println(strLine);
		        	 	
		        	 	while (posn >= 0)
				    {
				         posn = strLine.indexOf(' ',old_posn);
				         String next_word = (posn > 0) ? strLine.substring(old_posn,posn) : strLine.substring(old_posn);
				         System.out.println("Next word: "+ next_word);
				         
				         old_posn = posn + 1;
				    }
		         }
			 }
		} 
    		catch (FileNotFoundException e) 
    		{
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} 
    		catch (UnsupportedEncodingException e) 
    		{
    			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    		catch (IOException e) 
    		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		finally
    		{
    			if (pw != null)
    			{
    				pw.close();
    			}
    		}
    }
    
    public Map<String, User> getModel()
    {
        return contentProvider;
    }
}
