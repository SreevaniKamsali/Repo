package com.techmahindra;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/ResourceService") 

public class ResourceService {  
   ResourceDao resourceDao = new ResourceDao();  
   @GET 
   @Path("/resources") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<Resource> getResources(){ 
      return resourceDao.getAllResources(); 
   }  
}
