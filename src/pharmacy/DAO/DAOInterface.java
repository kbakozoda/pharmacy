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
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pharmacy";
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
    public abstract List getAll();          // nothing to say
    //public abstract Class getById(int id); // performs getAll() inside, then searches for object inside the list
    //public abstract int deleteById(int id); // possible results: -1 -> error 1-> okay
    //public abstract int update(Object obj); // possible results: -1 -> error 1-> okay
    //public abstract void insert(Object obj); // we assume that the object has passed the validator successfully
}
