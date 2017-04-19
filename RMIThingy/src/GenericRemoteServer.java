import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class GenericRemoteServer<T> {

	public GenericRemoteServer(IRGeneric<T> generic, String name) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			Object x = UnicastRemoteObject.exportObject(generic, 0);
			registry.bind(name, (Remote) x);
		} catch (AlreadyBoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
