package beans;

import javax.ejb.Remote;

import entity.User;

@Remote
public interface StatelessBeanTeam6Remote {
	/* Register user. Throws Exception if username is not unique */
    public void register(User user) throws Exception;
}
