package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Phone;
import entity.User;

/**
 * Session Bean implementation class StatelessBeanTeam6
 */
@Stateless
@LocalBean
public class StatelessBeanTeam6 implements StatelessBeanTeam6Remote {

	@PersistenceContext(name = "PhoneServerTeam6")
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
			throw new Exception("User with username " + user.getUsername() + "already exists. Please pick another one");
		}
		em.persist(user);
	}

	public void addPhone(Phone p) throws Exception {
		em.persist(p);
	}

	//TODO Return list of phones
	public List<Phone> searchPhones(Phone p) {
		try {
			String query = createPhoneSearchQuery(p);
			System.out.println(query);
			Query tq = em.createQuery(query);
			List<Phone> res = tq.getResultList();
			return res;
		} catch (Exception e) {
			return null;
		}
	}

	/* Help functions */

	private boolean nameIsUnique(String username) {
		try {
			TypedQuery<User> tq = em.createNamedQuery("User.getUserByUsername", User.class);
			tq.setParameter("username", username);
			User u = tq.getSingleResult();
			return u == null;
		} catch (Exception e) {
			return true;
		}
	}

	private String createPhoneSearchQuery(Phone p) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p FROM Phone p ");
		Boolean whereAppended = new Boolean(false);
		whereAppended = buildString("batteryCapacity", String.valueOf(p.getBatteryCapacity()), whereAppended, sb);
		whereAppended = buildString("model", p.getModel(), whereAppended, sb);
		whereAppended = buildString("operatingSystem", p.getOperatingSystem(), whereAppended, sb);
		whereAppended = buildString("producer", p.getProducer(), whereAppended, sb);
		whereAppended = buildString("cpuSpeed", String.valueOf(p.getCpuSpeed()), whereAppended, sb);
		whereAppended = buildString("height", String.valueOf(p.getHeight()), whereAppended, sb);
		whereAppended = buildString("memory", String.valueOf(p.getMemory()), whereAppended, sb);
		whereAppended = buildString("price", String.valueOf(p.getPrice()), whereAppended, sb);
		whereAppended = buildString("resolutionX", String.valueOf(p.getResolutionX()), whereAppended, sb);
		whereAppended = buildString("resolutionY", String.valueOf(p.getResolutionY()), whereAppended, sb);
		whereAppended = buildString("weight", String.valueOf(p.getWeight()), whereAppended, sb);
		whereAppended = buildString("width", String.valueOf(p.getWidth()), whereAppended, sb);

		return sb.toString();
	}

	private boolean buildString(String property, String propertyValue, Boolean whereAppended, StringBuilder sb) {
		if (propertyValue != null && !propertyValue.equals("") && !propertyValue.equals("0") && !propertyValue.equals("0.0")) {
			if (!whereAppended) {
				sb.append(" WHERE ");
				whereAppended = true;
			} else {
				sb.append(" AND ");
			}
			sb.append("p." + property + " = '" + propertyValue+"'");
		}
		return whereAppended;
	}

}
