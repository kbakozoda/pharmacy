package pharmacy.DAO;

import pharmacy.Models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class RolesDAO extends DAOInterface {
    public RolesDAO() {createConnection();}

    public List<Role> getAll() {
        List<Role> list = new ArrayList<Role>();
        Role temp;
        try {
            String sql = "SELECT * FROM roles";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                temp = new Role();
                temp.setId(id);
                temp.setName(name);
                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
