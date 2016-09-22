package pharmacy.DAO;

import pharmacy.DAO.DAOInterface;
import pharmacy.Models.Request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** requests to Admin */
public class RequestDAO extends DAOInterface {

    private String tableName = "requeststoadmin";

    public RequestDAO() {
        createConnection();
    }

    Request fetchRTGFromRs(ResultSet rs) {
        Request temp;
        temp = new Request();
        try {
            temp.setId(rs.getInt("id"));
            temp.setPassword(rs.getString("password"));
            temp.setUsername(rs.getString("username"));
            temp.setName(rs.getString("name"));
            temp.setSurname(rs.getString("surname"));
            temp.setNetworkId(rs.getInt("networkid"));
            temp.setPharmacyId(rs.getInt("pharmacyid"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }
    @Override
    public List getAll() {
        List list = new ArrayList<Request>();
        Request temp;
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

    public Request getById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Request temp;
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

    public List getByPhId(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Request temp;
        List<Request> list = new ArrayList<>();
        try {
            while (rs.next()) {
                if (rs.getInt("pharmacyid") == id) {
                    temp = fetchRTGFromRs(rs);
                    list.add(temp);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return list;
    }

    public List getByNwId(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Request temp;
        List<Request> list = new ArrayList<>();
        try {
            while (rs.next()) {
                if (rs.getInt("networkid") == id) {
                    temp = fetchRTGFromRs(rs);
                    list.add(temp);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return list;
    }

    public int deleteById(int id) {
        return removeById(id, tableName);
    }

    public void insert(Request obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.updateString("surname", obj.getSurname());
            rs.updateString("username", obj.getUsername());
            rs.updateString("password", obj.getPassword());
            rs.updateInt("networkid", obj.getNetworkId());
            rs.updateInt("pharmacyid", obj.getPharmacyId());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
