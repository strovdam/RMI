
public class RemoteServerMain {

	public static void main(String[] args) {
		new GenericRemoteServer<Double>(new IRGeneric<Double>() {
			public Double execute(Double param) {
				return param * param;
			}
		}, "Square");
	}
	
}
