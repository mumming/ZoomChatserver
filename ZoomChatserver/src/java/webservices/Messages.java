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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("messages")
public class Messages {
    
    @Context
    private UriInfo context;
    
    //static ArrayList<String> messages = new ArrayList<String>();
    static ArrayList<MessageObj> messages = new ArrayList<>();
    static int MESSAGE_COUNT = 0;
    final static String messSeparator = "<messsep>";
    final static String paramSeparator = "<paramsep>";
    
    private class MessageObj{
        int count;
        String username;
        String message;
        private MessageObj(int count, String username, String message){
            this.count = count;
            this.username = username;
            this.message = message;
        }
    }
    
    /**
     * Creates a new instance of PostmessageResource
     */
    public Messages() {
        
    }
    
    /**
     * Retrieves representation of an instance of webservices.PostmessageResource
     * @param lastIndex
     * @return an instance of java.lang.String
     * */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getmessages/")
    public String getMessages(@QueryParam("lastindex") int lastIndex) {
        System.out.println("getMessages kaldt");
        String joined = "";
        if(messages == null)
            return joined;
        for(int i = lastIndex+1; i < messages.size(); i++){
            if(i < messages.size()-1) // no message separator on last object
                joined = joined.concat(messages.get(i).count + paramSeparator + messages.get(i).username +
                        paramSeparator + messages.get(i).message + messSeparator);
            else
                joined = joined.concat(messages.get(i).count + paramSeparator + messages.get(i).username +
                        paramSeparator + messages.get(i).message);
            System.out.println("besked nr: " +messages.get(i).count);
        }
        System.out.println("getMessages done");
        return joined;
    }
    
    /**
     * PUT method for updating or creating an instance of PostmessageResource
     * @param nameAndMessage
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/send/")
    public void putText(String nameAndMessage) {
        //String username, message;
        //username = usernameAndMessage.split("-");
        //control.Controller.messages.add(username);
        System.out.println("putText kaldt");
        //control.Controller.messages.add(message);
        String[] nameAndMess = new String[2];
        nameAndMess = nameAndMessage.split(",", 2);
        messages.add(new MessageObj(MESSAGE_COUNT, nameAndMess[0], nameAndMess[1]));
        MESSAGE_COUNT++;
        System.out.println("last added message: "+messages.get(messages.size()-1).toString());
        System.out.println("putText done ");
        
    }
}
