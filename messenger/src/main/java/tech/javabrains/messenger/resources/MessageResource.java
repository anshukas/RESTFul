package tech.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tech.javabrains.messenger.model.Message;
import tech.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	/**
	 * This is 1st version of code where we are return plain text.
	 */
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "Hello World  in REST Full Web Service!";
	}*/
	
	/**
	 * This is 2nd version of code where we are return list of message in XML from the model.
	 * @return
	 */
	/*
		MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages(); 
	}
	 // This is test for Resource URI like this /messages/test
	@GET
	@Path("/test")	// this need to dynamic not static
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest(){
		return "hey I'm test";
	}
	 //This make this works - http://localhost:8080/messenger/webapi/messages/1
	@GET
	@Path("/{messageId}")		// this take any thing after /message/{messsageId}
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id){			// the jersey is cool as it know the type conversion i.e String to long is converted
		return messageService.getMessage(id); 
	}
*/	
	/**
	 * This is 3rd version - if you need to send the response as JSON then
	 * XML comes with java
	 * but JSON you need to add jar
	 * Go to prom.xml and uncomment <groupId>org.glassfish.jersey.media</groupId>
	 */
	
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages(); 
	}
	
	 //This make this works - http://localhost:8080/messenger/webapi/messages/1
	@GET
	@Path("/{messageId}")		// this take any thing after /message/{messsageId}
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){			// the jersey is cool as it know the type conversion i.e String to long is converted
		return messageService.getMessage(id); 
	}
	
	/**
	 * Now POST API
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	
}
