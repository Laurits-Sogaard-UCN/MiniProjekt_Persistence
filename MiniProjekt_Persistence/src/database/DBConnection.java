package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utility.DataAccessException;

public class DBConnection {
	
	private Connection connection = null;
	private static DBConnection dbConnection;
	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "DMA-CSD-V222_10414004";
	private static final String serverAddress = "hildur.ucn.dk";
	private static final int serverPort = 1433;
	private static final String userName = "DMA-CSD-V222_10414004";
	private static final String password = "Password1!";

	/**
	 * Constructor to create database access.
	 * @throws DataAccessException
	 */
	private DBConnection() throws DataAccessException {
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=false",
				serverAddress, serverPort, dbName, userName, password);
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Missing JDBC driver", e);

		} catch (SQLException e) {
			throw new DataAccessException(String.format("Could not connect to database %s@%s:%d user %s", dbName,
					serverAddress, serverPort, userName), e);
		}
	}

	/**
	 * Returns instance of DBConnection. If it does not already exist, it is created. 
	 * Implemented as a Singleton pattern.
	 * @return DBConnection
	 * @throws DataAccessException
	 */
	public static synchronized DBConnection getInstance() throws DataAccessException {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	/**
	 * Returns the connection to the database.
	 * @return Connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Closes the connection to the database.
	 */
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

