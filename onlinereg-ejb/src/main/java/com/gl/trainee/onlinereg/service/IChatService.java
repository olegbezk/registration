package com.gl.trainee.onlinereg.service;

import java.util.List;

import com.gl.trainee.onlinereg.model.Chat;

public interface IChatService {
	
	public void getChat(int id);
	
	public List<Chat> getChats();
	
	public void addChat(Chat chat);
	
	public void deleteChat(Chat chat);
	
	public void updateChat(Chat chat);

}
