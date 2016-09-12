package pharmacy.DAO;

import pharmacy.Models.DrugType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class DrugTypesDAO extends DAOInterface {
    public DrugTypesDAO() {createConnection();}

    public List<DrugType> getAll() {
        List<DrugType> list = new ArrayList<DrugType>();
        DrugType temp;
        try {
            String sql = "SELECT * FROM drugtypes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                temp = new DrugType();
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
