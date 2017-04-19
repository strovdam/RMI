package a3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AnsweringClient {
	public static void main(String[] args) {
		String host = "localhost";
		try {
			Registry registry = LocateRegistry.getRegistry(host, 5555);
			IRAnswering a = (IRAnswering) registry.lookup("Answer"); 
			RemoteAnswerCallback ac = new RemoteAnswerCallback();
			
			IRAnswerCallback remote = (IRAnswerCallback) UnicastRemoteObject.exportObject(ac, 0);
			
			a.answer("What is the answer to life, the universe and everything?", remote);
			System.out.println("Message sent!");
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
