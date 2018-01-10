package fr.cinema.client;

import java.io.*;
import java.util.*;
import fr.cinema.client.Movie;

public enum MovieManager 
{
	instance;

    private Map<String, Movie> contentProvider = new HashMap<>();
    private File fichier = new File("movie_database.txt") ;
    private PrintWriter pw;
    private FileInputStream fis;
    private FileOutputStream fos;
    private byte[] bytesArray;
    private String str;

    private MovieManager() 
    {
    		try 
    		{
    			 fis = new FileInputStream("movie_database.txt"); // Lecture
    			 fos = new FileOutputStream(fichier); // Écriture
			
    			 if (!fichier.exists())
    			 {
    				 fichier.createNewFile();
    			 }
    			 
			 if (fichier.length() == 0)
			 {
				 System.out.println("Le fichier est vide, ajout de 3 utilisateurs par défaut"); 
				 
				 Movie movie = new Movie("1", "Suicid Squad", "2h03", "David Ayer", "Anglais", "Français", "Will Smith");
		         contentProvider.put("1", movie);
		        
		         str = movie.getId() + ":" + movie.getTitle() + ":" + movie.getDuration() + ":" + movie.getDirector();
		         bytesArray = str.getBytes();
		         fos.write(bytesArray);
		   	  	 fos.flush();
		         
		   	  	 movie = new Movie("2", "The Dark Knight Rises", "2h44", "Christopher Nolan", "Anglais", "Français", "Christian Bale");
		         contentProvider.put("2", movie);
		        
		         str = movie.getId() + ":" + movie.getTitle() + ":" + movie.getDuration() + ":" + movie.getDirector();
		         bytesArray = str.getBytes();
		         fos.write(bytesArray);
		   	  	 fos.flush();
		   	  	 
		   	  	 movie = new Movie("3", "Fast & Furious 7", "2h17", "James Wan", "Anglais", "Français", "Vin Diesel");
		         contentProvider.put("3", movie);
		        
		         str = movie.getId() + ":" + movie.getTitle() + ":" + movie.getDuration() + ":" + movie.getDirector();
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
    
    public Map<String, Movie> getModel()
    {
        return contentProvider;
    }
}