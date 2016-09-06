package pharmacy.DAO;

import java.util.ArrayList;
import java.util.List;
import pharmacy.Models.Developer;
import java.sql.*;
import java.io.*;
/**
 * Created by User on 04.09.2016.
 */
public class DevelopersList {

    private List<Developer> developerList;

    static String JDBC_DRIVER;
    static String USER;
    static String PASS;
    static String DB_URL;
    Connection conn;
    Statement stmt;
    Developer temp;

    public DevelopersList() {
        JDBC_DRIVER="com.mysql.jdbc.Driver";
        DB_URL="jdbc:mysql://localhost:3306/pharmacy";
        USER = "root";
        PASS = "";
        conn = null;
        stmt = null;

        updateAndFetch();
    }

    public void updateAndFetch() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();

            String sql = "SELECT id , name, surname FROM sqltest";
            ResultSet rs = stmt.executeQuery(sql);

            developerList = new ArrayList<Developer>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surn = rs.getString("surname");
                temp = new Developer();
                temp.setId(id);
                temp.setName(name);
                temp.setSurname(surn);

                developerList.add(temp);
            }
            // TODO : Maybe move this closings to a separate function
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(conn!=null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try{
                if(stmt!=null) stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }

    }

    public List<Developer> getList() {
        return developerList;
    }

}
