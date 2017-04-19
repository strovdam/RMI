import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IRSquarable extends Remote {

	public long square(long x) throws RemoteException;
	
}
