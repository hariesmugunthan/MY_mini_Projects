import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class DbConnection {
    Connection con;
    static Scanner o=new Scanner(System.in);
    DbConnection() throws SQLException {
        String url="jdbc:mysql://localhost:3306/milk";
        String username="root";
        String password="1977";
        //ESTABLISH A CONNECTION

         con= DriverManager.getConnection(url,username,password);
    }


}
