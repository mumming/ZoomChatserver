/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import control.Controller;
import java.util.StringJoiner;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("getmessages")
public class GetmessagesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetmessagesResource
     */
    public GetmessagesResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.GetmessagesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessages() {
        String joined = "";
        for(int i = 0; i < control.Controller.messages.size(); i++){
            if(i%2==0)
                joined.concat("\n");
            joined.concat(control.Controller.messages.get(i));
        }
        return joined;
    }

    /**
     * PUT method for updating or creating an instance of GetmessagesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
