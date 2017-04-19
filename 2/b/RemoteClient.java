import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RemoteClient {

	public static void main(String[] args) {
		String host = "localhost";
		try {
			Registry registry = LocateRegistry.getRegistry(host, 5555);
			@SuppressWarnings("unchecked")
			IRGeneric<Double> sq = (IRGeneric<Double>) registry.lookup("Square"); 
			double four = sq.execute(-2.0);
			System.out.println(four);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
