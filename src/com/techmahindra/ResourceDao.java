package com.techmahindra;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

import com.techmahindra.Resource;
public class ResourceDao { 
	   
	@SuppressWarnings("unchecked")
	public List<Resource> getAllResources(){
		
	      List<Resource> resourceList = null; 
    
	      try { 
	         File file = new File("Resources.dat"); 
	         
			if (!file.exists()) { 
	        	 Resource resource= new Resource(1, "Lawanya", "Software"); 
	        	 resourceList = new ArrayList<Resource>(); 
	        	 resourceList.add(resource); 
	            saveResourceList(resourceList);
	         } 
	         else{ 
	            FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	           
	            resourceList = (ArrayList<Resource>) ois.readObject(); 
	            ois.close(); 
	         } 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } catch (ClassNotFoundException e) { 
	         e.printStackTrace(); 
	      }   
	      return resourceList; 
	   } 
	   private void saveResourceList(List<Resource> resourceList){ 
	      try { 
	         File file = new File("Resources.dat"); 
	         FileOutputStream fos;  
	         fos = new FileOutputStream(file); 
	         ObjectOutputStream oos = new ObjectOutputStream(fos); 
	         oos.writeObject(resourceList); 
	         oos.close(); 
	      } catch (FileNotFoundException e) { 
	         e.printStackTrace(); 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } 
	   }    
	}


