import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDB {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			try {
//				Context initContext = new InitialContext();
//
//				Context envContext = (Context) initContext.lookup("java:/comp/env");
//				DataSource ds = (DataSource) envContext.lookup("jdbc/mySQL");
//				conn = ds.getConnection();
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
               conn = (Connection) DriverManager.getConnection("jdbc:mysql://mysql:3306/decentralize", "admin", "admin");

			} catch (Exception e) {
		
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conn;
	}

}
