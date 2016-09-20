package pharmacy.DAO;

import pharmacy.Models.Drug;

import java.sql.*;
import java.util.List;

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
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet getRSForSelAll(String tablename) {
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM " + tablename;
            rs = stmt.executeQuery(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return rs;
    }

    public int removeById(int id, String tableName) {
        try {
            String sql = "DELETE FROM " + tableName+ "WHERE id=" + id;
            int rs = stmt.executeUpdate(sql);
            return 1;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }
    public abstract List getAll();          // nothing to say
    //public abstract Class getById(int id); // performs getAll() inside, then searches for object inside the list
    //public abstract int deleteById(int id); // possible results: -1 -> error 1-> okay
    //public abstract int update(Object obj); // possible results: -1 -> error 1-> okay
    //public abstract void insert(Object obj); // we assume that the object has passed the validator successfully
}
