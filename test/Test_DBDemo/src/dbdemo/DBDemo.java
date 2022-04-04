package dbdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class DBDemo {

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "123456789";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/**
	 * The name of the database we are testing with (this default is installed with
	 * MySQL)
	 */
	private final String dbName = "murach";

	/** The name of the table we are testing with */
	private final String tableName = "product";

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */

	class Product {
		private String code, description;
		private double price;

		public Product(String code, String description, double price) {
			this.code = code;
			this.description = description;
			this.price = price;
		}

		public String getCode() {
			return code;
		}

		public String getDescription() {
			return description;
		}

		public double getPrice() {
			return price;
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	// Create a table
	public void createTable() {
		try {
			Connection conn = this.getConnection();
			String createString = "CREATE TABLE " + this.tableName + " ( " +
					"Code varchar(40) NOT NULL, " +
					"Description varchar(40) NOT NULL, " +
					"Price INTEGER NOT NULL, " +
					"PRIMARY KEY (CODE))";
			this.executeUpdate(conn, createString);
			System.out.println("Created a table");

		} catch (SQLException e) {
			System.out.println("ERROR: Could not create the table");
			e.printStackTrace();
			return;
		}
	}

	public void getProduct() {
		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();
			ResultSet products = statement.executeQuery("SELECT * FROM Product ");
			while (products.next()) {
				System.out.println(products.getString("Code") + " " + products.getString("Description") + " "
						+ products.getString("Price"));
			}
		} catch (Exception e) {
			System.out.println(1);
		}
	}

	// Insert
	public void dropTable() {
		try {
			Connection conn = this.getConnection();
			String dropString = "DROP TABLE " + this.tableName;
			this.executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
			return;
		}
	}

	public void insert() {
		String ds[] = { "Code", "Description", "Price" };
		Scanner in = new Scanner(System.in);
		ArrayList<String> s = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			System.out.print("Nhap " + ds[i] + ": ");
			s.add(in.nextLine());
		}
		in.close();
		try {
			Connection conn = this.getConnection();
			String query = "INSERT INTO Product (Code, Description, Price) " +
					"VALUES ('" + s.get(0) + "', " +
					"'" + s.get(1) + "', " +
					"'" + s.get(2) + "')";
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println("ERROR: Could not insert the record");
			e.printStackTrace();
			return;
		}
	}

	public void searchRecord(String type, String record) {
		try {
			Connection conn = this.getConnection();
			String query = "SELECT * FROM Product " + "WHERE " + type + "='" + record + "'";
			Statement statement = conn.createStatement();
			ResultSet products = statement.executeQuery(query);
			while (products.next()) {
				System.out.println(products.getString("Code") + " " + products.getString("Description") + " "
						+ products.getString("Price"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR: Could not find the record");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		DBDemo app = new DBDemo();
		Scanner in = new Scanner(System.in);
		String menu = "Menu\n" +
				"1. Create Table\n" +
				"2. Insert a product\n" +
				"3. Get a table\n" +
				"4. Get a record\n" +
				"5. Exit";
		boolean run = true;
		while (run) {
			System.out.println(menu);
			int choice = Integer.parseInt(in.nextLine());
			switch (choice) {
				case 1:
					app.createTable();
					break;
				case 2:
					app.insert();
					break;
				case 3:
					app.getProduct();
					break;
				case 4: {
					System.out.println("Do you want to search by Code or Description?\n1. Code\n2. Description");
					int choice2 = Integer.parseInt(in.nextLine());
					System.out.print("Enter information: ");
					String query = in.nextLine();
					switch (choice2) {
						case 1:
							app.searchRecord("Code", query);
							break;
						case 2:
							app.searchRecord("Description", query);
							break;
					}
					break;
				}
				case 5:
					run = false;
					break;
			}
		}
		in.close();
	}
}