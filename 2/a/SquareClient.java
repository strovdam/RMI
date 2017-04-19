import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SquareClient {

	public static void main(String[] args) {
		String host = "localhost";
		try {
			Registry registry = LocateRegistry.getRegistry(host, 5555);
			IRSquarable s = (IRSquarable) registry.lookup("Square"); 
			double four = s.square(2);
			System.out.println(four);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
