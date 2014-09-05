package com.gl.trainee.onlinereg.dao;

import java.util.List;

import com.gl.trainee.onlinereg.model.Chat;

public interface IChatDAO {
	
	public void addChat(Chat chat);
	
	public void deleteChat(Chat chat);
	
	public void updateChat(Chat chat);
	
	public Chat getChat(int id);
	
	public List<Chat> getChats();
	
	

}
