package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.User;

/**
 * Session Bean implementation class StatelessBeanTeam6
 */
@Stateless
@LocalBean
public class StatelessBeanTeam6 implements StatelessBeanTeam6Remote {

	@PersistenceContext(name="PhoneServerTeam6")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public StatelessBeanTeam6() {
        // TODO Auto-generated constructor stub
    }
    
    public void register(User user) throws Exception {
		  boolean ok = nameIsUnique(user.getUsername());
    	if (!ok) {
    		throw new Exception("User with username "+user.getUsername()+"already exists. Please pick another one");
    	}
    	em.persist(user);
    }
    
    
    
    
	private boolean nameIsUnique(String username) {
		try {
		  TypedQuery<User> tq = em.createNamedQuery("User.getUserByUsername",User.class);
		  tq.setParameter("username", username);
		  User u = tq.getSingleResult();
		  return u == null;
		} catch (Exception e) {
			return true;
		}

	}

}
