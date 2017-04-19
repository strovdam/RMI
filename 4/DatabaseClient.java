import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseClient {

	public static void main(String[] args) {
		String host = "localhost";
		Scanner reader = new Scanner(System.in);
		String line = "";
		try {
			//Remote Object loaded
			Registry registry = LocateRegistry.getRegistry(host, 5555);
			IRDatabase db = (IRDatabase) registry.lookup("database"); 
			
			//db.createTable("tbl", "id int not null, name varchar(255), Primary Key(id)");
			//db.insertInto("tbl", "id, name", "1, 'Damian'", "2, 'Maxi'", "3, 'Ivan'", "4, 'Loris'");
			//db.update("tbl", "id", "5", "id = 2");
			//db.delete("tbl", "id < 3");
			//db.dropTable("tbl");
			//db.execute("Create table Test(id int);");
			
			//The following loop contains the user input handling
			while(!line.equals("x")) {
				System.out.println("Please enter your desired action [1 - create | 2 - insert | 3 - update | 4 - delete | 5 - drop | x - exit]");
				line = reader.nextLine();
				if(line.equals("1")) {
					System.out.print("Enter new table name: ");
					String tbl = reader.nextLine();
					List<String> strings = new ArrayList<>();
					String x = "";
					do {
						System.out.print("New paramter line: ");
						x = reader.nextLine();
						if(!x.equals("")) {
							strings.add(x);
						}
					} while(!x.equals(""));
					String[] lines = new String[strings.size()];
					int i = 0;
					for(String s : strings) {
						lines[i++] = s;
					}
					db.createTable(tbl, lines);
				} else if(line.equals("2")) {
					System.out.print("Enter table name: ");
					String tbl = reader.nextLine();
					System.out.print("Enter the attributes you want to assign -- [att. a],[att.b],... ");
					String atts = reader.nextLine();
					
					List<String> strings = new ArrayList<>();
					String x = "";
					do {
						System.out.print("New value line(Please use '' for Strings) -- [val a],[val b],... ");
						x = reader.nextLine();
						if(!x.equals("")) {
							strings.add(x);
						}
					} while(!x.equals(""));
					String[] lines = new String[strings.size()];
					int i = 0;
					for(String s : strings) {
						lines[i++] = s;
					}
					
					db.insertInto(tbl, atts, lines);
				} else if(line.equals("3")) {
					System.out.print("Enter table name: ");
					String tbl = reader.nextLine();
					System.out.print("Enter attribute name: ");
					String att = reader.nextLine();
					System.out.print("Enter new value(Please use '' for Strings): ");
					String newval = reader.nextLine();
					System.out.print("Enter condition(Please use '' for Strings) -- [att a] > 10 ");
					String where = reader.nextLine();
					db.update(tbl, att, newval, where);
				} else if(line.equals("4")) {
					System.out.print("Enter table name: ");
					String tbl = reader.nextLine();
					System.out.print("Enter condition(Please use '' for Strings) -- [att a] > 10 ");
					String where = reader.nextLine();
					db.delete(tbl, where);
				} else if(line.equals("5")) {
					System.out.print("Enter table name: ");
					String tbl = reader.nextLine();
					db.dropTable(tbl);
				} else if(line.equals("x")) {
					System.out.println("Bye!");
				} else {
					System.out.println("Wrong Syntax");
				}
			}
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		reader.close();
	}

}
