package pharmacy.DAO;

import pharmacy.Models.Network;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class NetworkDAO extends DAOInterface {
    public NetworkDAO() {
        createConnection();
    }

    public List<Network> getAll() {
        List<Network> list = new ArrayList<Network>();
        Network temp;
        try{
            String sql = "SELECT * FROM networks";
            ResultSet rs = stmt.executeQuery(sql);

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
        }
        return list;
    }
}
