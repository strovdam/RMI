
public class MySecurityManager extends SecurityManager {
	public MySecurityManager() {
		System.setProperty("java.security.policy", "src/rmi.policy");
		System.setProperty("java.rmi.server.hostname","localhost");
	}
}
