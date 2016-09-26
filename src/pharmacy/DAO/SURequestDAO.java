package pharmacy.DAO;


import pharmacy.Models.RequestToGod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SURequestDAO extends DAOInterface{

    public SURequestDAO(){
        createConnection();
    }

    private static final String tableName = "requeststogod";

    RequestToGod fetchRTGFromRs(ResultSet rs) {
        RequestToGod temp;
        temp = new RequestToGod();
        try {
            temp.setId(rs.getInt("id"));
            temp.setPassword(rs.getString("password"));
            temp.setUsername(rs.getString("username"));
            temp.setName(rs.getString("name"));
            temp.setSurname(rs.getString("surname"));
            temp.setNetworkId(rs.getInt("networkid"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }
    @Override
    public List getAll() {
        List list = new ArrayList<RequestToGod>();
        RequestToGod temp;
        try {
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchRTGFromRs(rs);
                list.add(temp);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    public RequestToGod getById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        RequestToGod temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchRTGFromRs(rs);
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
    public int deleteByNetworkId(int id) {
        return removeByNetworkId(id, tableName);
    }

    public void insert(RequestToGod obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.updateString("surname", obj.getSurname());
            rs.updateString("username", obj.getUsername());
            rs.updateString("password", obj.getPassword());
            rs.updateInt("networkid", obj.getNetworkId());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
