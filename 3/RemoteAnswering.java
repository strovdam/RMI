package a3;
import java.rmi.RemoteException;

public class RemoteAnswering implements IRAnswering {

	@Override
	public void answer(String question, IRAnswerCallback callback) throws RemoteException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String ret = "Die Antword auf deine " + question + " ist wahrscheinlich 42";
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				try {
					callback.answer(ret);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}

	
	
}
