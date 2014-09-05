package com.gl.trainee.onlinereg.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gl.trainee.onlinereg.model.Chat;

@Stateless
public class ChatDAO implements IChatDAO {

	@PersistenceContext
	private EntityManager em;

	public Chat getChat(int id) {
		Chat chat = (Chat) em.getReference(
				Chat.class, id);
		return chat;
	}

	public void deleteChat(Chat chat) {
		em.remove(chat);

	}

	public void addChat(Chat chat) {
		em.persist(chat);

	}

	@Override
	public List<Chat> getChats() {
		List list = em
				.createQuery("from Chat").getResultList();
		return list;
	}

	@Override
	public void updateChat(Chat chat) {
		em.refresh(chat);

	}
}
