package com.gl.trainee.onlinereg.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.gl.trainee.onlinereg.dao.IChatDAO;
import com.gl.trainee.onlinereg.model.Chat;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ChatService implements IChatService {

	@EJB
	private IChatDAO chatDAO;

	public IChatDAO getChatDAO() {
		return chatDAO;
	}

	public void setChatDAO(IChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	@Override
	public void getChat(int id) {
		chatDAO.getChat(id);
	}

	@Override
	public List<Chat> getChats() {
		return getChatDAO().getChats();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addChat(Chat chat) {
		getChatDAO().addChat(chat);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteChat(Chat chat) {
		getChatDAO().deleteChat(chat);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void updateChat(Chat chat) {
		getChatDAO().updateChat(chat);
		
	}

}
