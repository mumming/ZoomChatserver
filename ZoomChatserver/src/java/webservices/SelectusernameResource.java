/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package webservices;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("selectusername")
public class SelectusernameResource {
    
    
    @Context
    private UriInfo context;
    
    static ArrayList<String> users = new ArrayList<>();
    
    /**
     * Creates a new instance of SelectusernameResource
     */
    public SelectusernameResource() {
    }
    
    
    /**
     * PUT method for updating or creating an instance of SelectusernameResource
     * @param username
     * @return
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String putXml(String username) {
        if(username==null)
            return "false";
        if(users == null){
            users.add(username);
            return "true";
        }
        for(String s: users){
            if(s.equals(username))
                return "false";
        } 
        users.add(username);
        return "true";
    }
}
