package pharmacy.DAO;

import pharmacy.Models.Network;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NetworkDAO extends DAOInterface {
    public NetworkDAO() {
        createConnection();
    }

    private static final String tableName = "networks";

    Network fetchNetwFromRs(ResultSet rs) {
        Network temp;
        temp = new Network();
        try {
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setAdminId(rs.getInt("adminid"));
            temp.setActive(rs.getBoolean("active"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }
    public List<Network> getAll() {
        List<Network> list = new ArrayList<Network>();
        Network temp;
        try{
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchNetwFromRs(rs);
                list.add(temp);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Network getById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Network temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchNetwFromRs(rs);
                    return temp;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public int deleteById(int id) {
        return removeById(id, tableName);
    }

    public int update(Network obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            Network temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateString("name", obj.getName());
                    rs.updateBoolean("active", obj.isActive());
                    rs.updateInt("adminid", obj.getAdminId());
                    rs.updateRow();
                    return 1;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

    public void insert(Network obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.updateInt("adminid", obj.getAdminId());
            rs.updateBoolean("active", obj.isActive());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
