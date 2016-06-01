package db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.User;

public class DBManagerTeam6 {

	@PersistenceContext(name="PhoneServerTeam6")
	private EntityManager em;
	
	public User login(String username,String password) {
	  TypedQuery<User> tq = em.createNamedQuery("User.getLoggedUser",User.class);
	  tq.setParameter("username", username);
	  tq.setParameter("password", password);
	  User user = tq.getSingleResult();
	  return user;
	}
	
	public void register(User user) {
		em.persist(user);
	}
	
	public boolean nameIsUnique(String username) {
		  TypedQuery<User> tq = em.createNamedQuery("User.getUserByUsername",User.class);
		  tq.setParameter("username", username);
		  User u = tq.getSingleResult();
		  return u == null;

	}
	
}
