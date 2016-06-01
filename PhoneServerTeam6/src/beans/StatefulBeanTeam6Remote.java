package beans;

import javax.ejb.Remote;

import entity.User;

@Remote
public interface StatefulBeanTeam6Remote {

	/* Logging in user if data is correct, otherwise throws exception. */
	public void login(String username, String password)  throws Exception ;
	public User getLoggedUser();
	public void logout();
	
}
