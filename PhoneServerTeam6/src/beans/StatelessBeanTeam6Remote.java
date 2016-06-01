package beans;

import java.util.List;

import javax.ejb.Remote;

import entity.Phone;
import entity.User;

@Remote
public interface StatelessBeanTeam6Remote {
	/* Register user. Throws Exception if username is not unique */
    public void register(User user) throws Exception;
    public void addPhone(Phone p) throws Exception;
    public List<Phone> searchPhones(Phone p);
}
