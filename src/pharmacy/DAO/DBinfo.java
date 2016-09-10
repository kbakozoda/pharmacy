package pharmacy.DAO;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by User on 10.09.2016.
 */
public class DBinfo {
    public static String JDBC_DRIVER;
    public static String USER;
    public static String PASS;
    public static String DB_URL;
    public Connection conn;
    public Statement stmt;

    public DBinfo() {
        JDBC_DRIVER="com.mysql.jdbc.Driver";
        DB_URL="jdbc:mysql://localhost:3306/pharmacy";
        USER = "root";
        PASS = "";
    }
}
