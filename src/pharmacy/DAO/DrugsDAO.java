package pharmacy.DAO;

import pharmacy.Models.Drug;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by User on 12.09.2016.
 */
public class DrugsDAO extends DAOInterface {

    public DrugsDAO() {
        createConnection();
    }

    public List<Drug> getAll() {
        List<Drug> list = new ArrayList<Drug>();
        Drug temp;
        try {
            String sql = "SELECT * FROM drugs";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String instruction = rs.getString("instruction");
                int ageRestriction = rs.getInt("agerestriction");
                int typeId = rs.getInt("typeid");
                temp = new Drug();
                temp.setId(id);
                temp.setName(name);
                temp.setAgeRestrict(ageRestriction);
                temp.setInstruction(instruction);
                temp.setTypeId(typeId);

                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*public boolean insertDrug(Drug) {

    }

    public boolean updateDrug(Drug) {

    }

    public boolean deleteDrug(Drug) {

    }

    public Drug getDrug(int id) {

    }*/

}
