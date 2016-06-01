package beans;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeansManagerTeam6 {

	private InitialContext ctx;
	private static final String PROJECT_NAME = "PhoneServerTeam6";
	
	public BeansManagerTeam6() throws NamingException {
		ctx = new InitialContext();
	}
	
	public StatelessBeanTeam6Remote getStatelessBean() throws NamingException {
		StatelessBeanTeam6Remote statelessBR = (StatelessBeanTeam6Remote) ctx.lookup(
					"ejb:/"+PROJECT_NAME+"//"+StatelessBeanTeam6.class.getSimpleName()+
					"!"+StatelessBeanTeam6Remote.class.getName()
				);
		return statelessBR;
	}
	
	public StatefulBeanTeam6Remote getStatefulBean() throws NamingException {
		StatefulBeanTeam6Remote statefulBR = (StatefulBeanTeam6Remote) ctx.lookup(
					"ejb:/"+PROJECT_NAME+"//"+StatefulBeanTeam6.class.getSimpleName()+
					"!"+StatefulBeanTeam6Remote.class.getName()+"?stateful"
				);
		return statefulBR;
	}
	
	public SingletonBeanTeam6Remote getSingletonBean() throws NamingException {
		SingletonBeanTeam6Remote singletonBR = (SingletonBeanTeam6Remote) ctx.lookup(
					"ejb:/"+PROJECT_NAME+"//"+SingletonBeanTeam6.class.getSimpleName()+
					"!"+SingletonBeanTeam6Remote.class.getName()
				);
		return singletonBR;
	}
	
}
