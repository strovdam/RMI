import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServer {

	
	public DatabaseServer() {
		try {
			//Connection to database established.
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			java.sql.Connection c = DriverManager.getConnection("jdbc:mysql://37.114.61.89/EeU?" +
				                                   "user=RMIUser&password=1234");
			
			//Register rmi service.
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			RemoteDatabase rd = new RemoteDatabase();
			rd.setConnection(c);
			IRDatabase remote = (IRDatabase) UnicastRemoteObject.exportObject(rd, 0);
			
			registry.bind("database", remote);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
