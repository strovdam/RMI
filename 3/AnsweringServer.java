package a3;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AnsweringServer {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			

			RemoteAnswering a = new RemoteAnswering();
			IRAnswering remote = (IRAnswering) UnicastRemoteObject.exportObject(a, 0);
			
			
			registry.bind("Answer", remote);
		} catch (AlreadyBoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
