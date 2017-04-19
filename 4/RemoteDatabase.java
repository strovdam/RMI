import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoteDatabase implements IRDatabase {

	private Connection connection;
	
	//Executes SQL-Queries.
	private void executeQuery(String query) {
		System.out.println(query);
		try {
			java.sql.Statement stm = connection.createStatement();
			stm.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Client can execute any query.
	@Override
	public void execute(String query) throws RemoteException {
		executeQuery(query);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) throws RemoteException {
		this.connection = connection;
	}

	//Creates table from name and any number of parameters (like "id int not null" or "Primary Key(id)").
	@Override
	public void createTable(String name, String... lines) throws RemoteException {
		String msg = "Create table " + name + " (";
		for(String line : lines) {
			msg += line + ", ";
		}
		msg = msg.substring(0, msg.length()-2);
		msg += ");";
		executeQuery(msg);
	}

	//Drops table with specified name.
	@Override
	public void dropTable(String name) throws RemoteException {
		String query = "Drop table " + name + ";";
		executeQuery(query);
	}

	//Inserts into table using specified attributes and any number of value groups.
	@Override
	public void insertInto(String table, String attributes, String... values) throws RemoteException {
		String query = "Insert into " + table + " (" + attributes + ") values";
		for(String line : values) {
			query += "(" + line + "), ";
		}
		query = query.substring(0, query.length()-2);
		executeQuery(query);
	}

	//Updates table's specified attribute using a given where-clause (like "id > 2").
	@Override
	public void update(String table, String attribute, String newVal, String where) throws RemoteException {
		String query = "Update " + table + " SET " + attribute + " = " + newVal + " WHERE " + where;
		executeQuery(query);
	}

	//Deletes values using a given where-clause.
	@Override
	public void delete(String table, String where) throws RemoteException {
		String query = "Delete from " + table + " WHERE " + where;
		executeQuery(query);
	}
	
	
	
}
