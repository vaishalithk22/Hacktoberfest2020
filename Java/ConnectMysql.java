import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {
	private final static String NAME_DB = "";
	private static Connection connect;
	
    static {
    	String driver = "com.mysql.cj.jdbc.Driver";
        String server = "jdbc:mysql://localhost:3306/" + NAME_DB;
        String user = "root";
        String pass = "";
    	try {
			Class.forName(driver);
			connect = DriverManager.getConnection(server, user, pass);
		} catch (ClassNotFoundException e1) {
			System.out.println("erro");
			e1.printStackTrace();
		} catch (SQLException e) {
			System.out.println("erro2");
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection(){

		return connect;
	}
}
