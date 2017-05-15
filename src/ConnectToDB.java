import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDB {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			try {

//				String HostName = System.getenv("OPENSHIFT_EXTMYSQL_DB_HOST");
//				String HostPort = System.getenv("OPENSHIFT_EXTMYSQL_DB_PORT");
//				String DBName = System.getenv("OPENSHIFT_EXTMYSQL_DB_NAME");
//				String DBUser = System.getenv("OPENSHIFT_EXTMYSQL_DB_USERNAME");
//				String DBPassword = System.getenv("OPENSHIFT_EXTMYSQL_DB_PASSWORD");
//
//				Properties connectionProps = new Properties();
//				connectionProps.put("user", DBUser);
//				connectionProps.put("password", DBPassword);
//
//				String ConnectionURL = "jdbc:mysql://" + HostName + ":" + HostPort + "/" + DBName;
//
//				
//
//				System.out.println(" Creating connecton with ConnectionURL " + ConnectionURL + " connectionProps "
//						+ connectionProps);
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				 conn = (Connection)
				 DriverManager.getConnection("jdbc:mysql://mysql.aes-encrytion.svc:3306/decentralize",
				 "admin", "admin");
				
//				conn = (Connection) DriverManager.getConnection(ConnectionURL, connectionProps);

			} catch (Exception e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conn;
	}

}
