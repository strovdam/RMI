import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RemoteServer {

	public static void main(String[] args) {
		
		
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			

			RemoteSquare rs = new RemoteSquare();
			IRSquarable remote = (IRSquarable) UnicastRemoteObject.exportObject(rs, 0);
			
			
			registry.bind("Square", remote);
		} catch (AlreadyBoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
