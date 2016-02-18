package tech.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tech.javabrains.messenger.database.DatabaseClass;
import tech.javabrains.messenger.model.Message;

public class MessageService {
	
	/**
	 * This is 1st version of code
	 */
	/*public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hello World!", "Anshu");
		Message m2 = new Message(2L, "Hello Jersey!", "Anshu");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}*/
	
	/**
	 * This is 2nd version of code.
	 */
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1L, "Hello World!", "Anshu Kansakar"));
		messages.put(2L, new Message(2L, "Hello Jersey!", "Anshu Kansakar"));
	}
	
	public List<Message> getAllMessages(){
		// Passing the Collection to the ArrayList constructor initialized the List with those elements!
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message){
		if(message.getId() <=0 ){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	
	
	
	
	
	
}
