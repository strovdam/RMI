package a3;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRAnswerCallback extends Remote {
	public void answer(String message) throws RemoteException;
}
