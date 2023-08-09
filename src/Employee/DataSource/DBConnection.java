package Employee.DataSource;
import java.sql.*;

public class DBConnection {

	public static Connection getConnection() {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String userName="hr";
		String pass="12345678";

		Connection con=null;

		try {
			//Step 1: Load Driver
			Class.forName(driver);

			//Step 2: Connection to Database
			con=DriverManager.getConnection(url, userName, pass);
			System.out.println("Connected to Database...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
