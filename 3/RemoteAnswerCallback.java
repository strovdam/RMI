package a3;
import java.io.Serializable;
import java.rmi.RemoteException;

public class RemoteAnswerCallback implements IRAnswerCallback, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4902784013943869593L;

	@Override
	public void answer(String message) throws RemoteException {
		System.out.println(message);
	}

}
