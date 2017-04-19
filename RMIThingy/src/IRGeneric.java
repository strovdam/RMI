import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IRGeneric<T> extends Remote {
	public T execute(T param) throws RemoteException;
}
