
public class RemoteServerMain {

	public static void main(String[] args) {
		new GenericRemoteServer<Double>(new IRGeneric<Double>() {
			public Double execute(Double param) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return Math.abs(param);
			}
		}, "Absolute");
	}
	
}
