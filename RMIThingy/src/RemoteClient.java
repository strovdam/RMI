import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RemoteClient {

	public static void main(String[] args) {
		String host = "localhost";
		try {
			Registry registry = LocateRegistry.getRegistry(host, 5555);
			IRGeneric<Double> abs = (IRGeneric<Double>) registry.lookup("Absolute"); 
			double four = abs.execute(-4.0);
			double four2 = abs.execute(-5.0);
			System.out.println(four);
			System.out.println(four2);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
