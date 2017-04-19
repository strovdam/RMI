package a3;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRAnswering extends Remote {

	public void answer(String question, IRAnswerCallback callback) throws RemoteException;
	
}
