import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRDatabase extends Remote {
	//Client can execute any query.
	public void execute(String query) throws RemoteException;
	//Creates table from name and any number of parameters (like "id int not null" or "Primary Key(id)").
	public void createTable(String name, String ... lines) throws RemoteException;
	//Drops table with specified name.
	public void dropTable(String name) throws RemoteException;
	//Inserts into table using specified attributes and any number of value groups.
	public void insertInto(String table, String attributes, String ... values) throws RemoteException;
	//Updates table's specified attribute using a given where-clause (like "id > 2").
	public void update(String table, String attribute, String newVal, String where) throws RemoteException;
	//Deletes values using a given where-clause.
	public void delete(String table, String where) throws RemoteException;
}
