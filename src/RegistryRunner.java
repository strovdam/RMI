import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class RegistryRunner {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(5555);
			while(true);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
