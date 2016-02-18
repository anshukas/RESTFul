package tech.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long id;
	private String messsage;
	private Date created;
	private String author;
	
	public Message(){
		
	}
	
	public Message(long id, String messsage, String author) {
		this.id = id;
		this.messsage = messsage;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getId(){
		return id;
	}
	public void setId(long id){
		this.id= id;
	}
	public String getMessage(){
		return messsage;
	}
	public void setMessage(String message){
		this.messsage = message;
	}
	public Date getCreated(){
		return created;
	}
	public void setCreated(Date created){
		this.created = created;
	}
	
	
}
