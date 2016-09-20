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

    public List<Request> executeSQLQ(String query){
        List<Request> list = new ArrayList<Request>();
        Request temp;
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int netwid = rs.getInt("networkid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int pharmacyid = rs.getInt("pharmacyid");

                temp = new Request();

                temp.setId(id);
                temp.setNetworkId(netwid);
                temp.setPharmacyId(pharmacyid);
                temp.setSurname(surname);
                temp.setName(name);
                temp.setPassword(password);
                temp.setUsername(username);

                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Request> getAll() {
        String sql = "SELECT * FROM requeststoadmin";
        return executeSQLQ(sql);
    }

    public List<Request> getAllFor(int id){
        String sql = "SELECT * FROM requeststoadmin WHERE networkid="+id;
        return executeSQLQ(sql);
    }

    public void insert(Request obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.updateString("surname", obj.getSurname());
            rs.updateString("username", obj.getUsername());
            rs.updateString("password", obj.getPassword());
            rs.updateInt("pharmacyid", obj.getPharmacyId());
            rs.updateInt("networkid", obj.getNetworkId());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
