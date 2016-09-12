package pharmacy.DAO;
import pharmacy.Models.Network;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.09.2016.
 */
public class NetworkList {
    private List<Network> list;
    DBinfo db;
    Network temp;

    public NetworkList() {
        db = new DBinfo();
        list = new ArrayList<Network>();
        fetch();
    }
    // TODO: maybe add number of pharmacies in this network?
    public void fetch() {
        try {
            Class.forName(db.JDBC_DRIVER);
            db.conn = DriverManager.getConnection(db.DB_URL,db.USER,db.PASS);
            db.stmt = db.conn.createStatement();
            String sql = "SELECT * FROM networks";
            ResultSet rs = db.stmt.executeQuery(sql);

            while (rs.next()) {
                temp = new Network();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setAdminId(rs.getInt("adminid"));
                temp.setActive(rs.getBoolean("active"));
                list.add(temp);
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

    public List<Network> getAll() {
        return list;
    }

    public void update() {
        
    }
}
