package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.User;

/**
 * Session Bean implementation class StatefulBeanTeam6
 */
@Stateful
@LocalBean
public class StatefulBeanTeam6 implements StatefulBeanTeam6Remote {

	private User loggedUser = null;

	/**
	 * Default constructor.
	 */
	public StatefulBeanTeam6() {
		// TODO Auto-generated constructor stub
	}

	public void login(String username, String password) throws Exception {
		User u = getUserFromDB(username, password);
		if (u == null) {
			throw new Exception("User data incorrect!");
		} else {
			loggedUser = u;
		}
	}

	public void logout() {
		loggedUser = null;
	}

	@PersistenceContext(name = "PhoneServerTeam6")
	private EntityManager em;

	private User getUserFromDB(String username, String password) {
		try {
			TypedQuery<User> tq = em.createNamedQuery("User.getLoggedUser", User.class);
			tq.setParameter("username", username);
			tq.setParameter("password", password);
			User user = tq.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/* Getters and setters */
	public User getLoggedUser() {
		return this.loggedUser;
	}

}
