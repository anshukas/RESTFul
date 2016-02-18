package tech.javabrains.messenger.database;

import java.util.Map;
import java.util.HashMap;

import tech.javabrains.messenger.model.Message;
import tech.javabrains.messenger.model.Profile;

public class DatabaseClass {
	// this is not thread safe not do such way code in production
	public static Map<Long, Message> messages = new HashMap<>();
	public static Map<Long, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	public static Map<Long, Profile> profiles(){
		return profiles;
	}
	
}
