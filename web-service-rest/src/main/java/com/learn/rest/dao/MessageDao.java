package com.learn.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn.rest.model.Comment;
import com.learn.rest.model.Message;
import com.learn.rest.model.Profile;
import com.learn.rest.service.exception.NoDataFoundException;

public class MessageDao {

	public MessageDao() {
		messages.put(1, new Message(1, "My first Message"));
	}

	public static Map<Integer, Message> messages = new HashMap<>();
	
	public static Map<Integer, Profile> profiles = new HashMap<>();
	
	public static Map<Integer, Comment> comments = new HashMap<>();
	
	
	
	
	public static List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public static List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}

	public static Message addMessage(Message message) {
		message.setMessageId(messages.values().size() +1);
		messages.put(message.getMessageId(), message);
		return message;
	}

	public static Message getMessageById(Integer messageId) {
		return messages.get(messageId);
	}
	
	public static List<Comment> getMessageComments(Integer messageId){
		if(!messages.containsKey(messageId)){
			throw new NoDataFoundException();
		}
//		comments.put(1, new Comment(1, "My commetns"));
		return new ArrayList<>(comments.values());
		
	}
	
	public static Comment addMessageComments(Integer messageId,Comment comment){
		if(!messages.containsKey(messageId)){
			throw new NoDataFoundException();
		}
		comment.setCommentId(comments.values().size()+1);
		comments.put(comment.getCommentId(), comment);
		return comment;
		
	}
	
	public static Comment getMessageCommentById(Integer messageId,Integer commentId){
		if(!messages.containsKey(messageId)){
			throw new NoDataFoundException();
		}
		return comments.get(commentId);
		
	}
	
}
