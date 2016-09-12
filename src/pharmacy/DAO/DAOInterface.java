package pharmacy.DAO;

import pharmacy.Models.Drug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public abstract class DAOInterface {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/pharmacy";
    public Connection conn;
    public Statement stmt;
    public void createConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public abstract List getAll();
}
