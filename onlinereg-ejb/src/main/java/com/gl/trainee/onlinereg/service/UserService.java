package com.gl.trainee.onlinereg.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.gl.trainee.onlinereg.dao.IUserDAO;
import com.gl.trainee.onlinereg.model.Role;
import com.gl.trainee.onlinereg.model.User;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UserService implements IUserService {

	@Resource(mappedName = "onlinereg/jms/connection-factory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "onlinereg/jms/email")
	private Queue queue;

	@EJB
	private IUserDAO userDAO;

	private Connection connection;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	public User getUserByRegInf(String login, String password) {
		return getUserDAO().getUserByRegInf(login, password);
	}

	public User getUserByLogin(String login) {
		return getUserDAO().getUserByLogin(login);
	}

	public List<User> getUsers() {
		return getUserDAO().getUsers();
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Role getRole(int id) {
		return userDAO.getRole(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Role addRole(Role role) {
		return userDAO.addRole(role);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Role setRole(Role role) {
		return userDAO.setRole(role);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Role deleteRole(Role role) {
		return userDAO.deleteRole(role);
	}

	@Override
	public List<Role> getRoles() {
		return getUserDAO().getRoles();
	}

	@Override
	public List<User> getUnregisteredUser() {
		return getUserDAO().getUnregistredUser();
	}

	@Override
	public void sendEmail(int usedId) {
		getUserDAO().getUserById(usedId);
		
		String text = getUserDAO().getUserById(usedId).getEmail();

		connection = null;
		Session session = null;

		try {

			connection = connectionFactory.createConnection();
			connection.start();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer mproducer = session.createProducer(queue);
			mproducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			TextMessage message = session.createTextMessage(text);

			mproducer.send(message);

		} catch (JMSException e) {
			throw new IllegalStateException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					throw new IllegalStateException(e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					throw new IllegalStateException(e);
				}
			}
		}
	}
}
