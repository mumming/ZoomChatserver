/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import brugerautorisation.transport.soap.Brugeraut;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import brugerautorisation.transport.soap.ILogIn;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("adminlogin")
public class AdminloginResource {

    @Context
    private UriInfo context;

    ILogIn ilogin = new Brugeraut();
    
    
    /**
     * Creates a new instance of AdminloginResource
     */
    public AdminloginResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.AdminloginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AdminloginResource
     * @param UidAndPW
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public String putXml(String UidAndPW) {
        String[] loginInfo = new String[2];
        loginInfo = UidAndPW.split(",", 2);
        boolean b = ilogin.login(loginInfo[0], loginInfo[1]);
        if(b)
            return "true";
        else
            return "false";
    }
}
