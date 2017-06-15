/*package tech.javabrains.messenger.client;
*//**
 * This is the client which call the messenger web service.
 *//*

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import tech.javabrains.messenger.model.Message;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MessengerClient {
	private static final String MESSENGER_URI = "http://localhost:8080/messenger/webapi/messages";
	
	public static void main(String[] args){
		
		try{
			Client client = Client.create();
			WebResource webResource = client.resource(MESSENGER_URI);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if(response.getStatus() !=200 ){
				throw new RuntimeException("Failed " + response.getStatus());
			}
			 String output= response.getEntity(String.class);
			 System.out.println(output);
			 jsonToObject(output);
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	public static Message jsonToObject(String json){
		Message message[] = null;
	      ObjectMapper mapper = new ObjectMapper();
	      try
	      {
	         message =  mapper.readValue(json, Message[].class);
	      } catch (JsonGenerationException e)
	      {
	         e.printStackTrace();
	      } catch (JsonMappingException e)
	      {
	         e.printStackTrace();
	      } catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	      for (int i = 0; i < message.length; i++) {
	    	  System.out.println(message[i].getMessage());
		}
	      
		return null;
	}
}
*/