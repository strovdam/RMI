import java.rmi.RemoteException;


public class RemoteSquare implements IRSquarable {

	@Override
	public long square(long num) throws RemoteException {
		return num * num;
	}

	
	
}
