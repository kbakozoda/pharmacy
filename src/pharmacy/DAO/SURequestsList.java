package pharmacy.DAO;
import pharmacy.Models.RequestToGod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.09.2016.
 */
public class SURequestsList {
    List<RequestToGod> sureqlist;
    DBinfo db;
    RequestToGod temp;

    public List<RequestToGod> getList() {
        return sureqlist;
    }

    public SURequestsList() {
        db = new DBinfo();
        fetch();
    }

    public void fetch() {
        try {
            Class.forName(db.JDBC_DRIVER);
            db.conn = DriverManager.getConnection(db.DB_URL,db.USER,db.PASS);
            db.stmt = db.conn.createStatement();
            String sql = "SELECT * FROM requeststogod";
            ResultSet rs = db.stmt.executeQuery(sql);

            sureqlist = new ArrayList<RequestToGod>();
            while (rs.next()) {
                temp = new RequestToGod();
                temp.setId(rs.getInt("id"));
                temp.setPassword(rs.getString("password"));
                temp.setUsername(rs.getString("username"));
                temp.setName(rs.getString("name"));
                temp.setSurname(rs.getString("surname"));
                temp.setNetworkId(rs.getInt("networkid"));

                sureqlist.add(temp);
            }

        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(db.conn!=null) db.conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try{
                if(db.stmt!=null) db.stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
}
