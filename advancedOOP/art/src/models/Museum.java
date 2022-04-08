package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Museum {
	private int index = 0;
    static int idx = 0;
    ArrayList<String> artwork;
    
    public Museum(){
    	this.index = idx++;
    }
    
	HashMap<Integer, ArrayList<String>> artType = new HashMap<Integer, ArrayList<String>>();
	
	
	public void addToMuseum(String type, String title, String author, String description, String material) {
		this.index = idx++;
		ArrayList<String> artwork = new ArrayList<String>();
			artwork.add(title);
			artwork.add(author);
			artwork.add(description);
			artwork.add(material);
		artType.put(index, artwork);
		
	}
	
	public void viewAllArt() {
		 Set<Integer> keys = artType.keySet();
		 for(Integer key : keys) {
	            System.out.println(); 
	            for(String name : artType.get(key)){
	                System.out.println(name);
	            }
		 }
	}
	
	public void viewRandomArt() {	
		int i = 1;
		
		while(i <= artType.size()){
            Random rand = new Random();
            int low = 1;
            int high = artType.size();
            int randInt = rand.nextInt(high-low) + low;
            
            ArrayList<String> temp = artType.get(i);
            ArrayList<String> tempTwo = artType.get(randInt);
            
            artType.replace(i, tempTwo);
            artType.replace(randInt, temp);
          
            
            i++;
        }
		viewAllArt();
	}
}
