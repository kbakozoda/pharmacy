package pharmacy.DAO;

import pharmacy.Models.Drug;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public Drug getById(int id) {
        List<Drug> list = getAll();
        for (Drug listElement: list) {
            if(listElement.getId() == id) {
                return listElement;
            }
        }
        return null;
    }

    public int deleteById(int id) {
        try {
            String sql = "DELETE FROM drugs WHERE drugs.id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            // TODO: learn how to get result of query execution, and check whether result is successful. EVERYWHERE!!!
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }

    public int update(Drug obj) {
        try {
            String sql = "UPDATE drugs SET name="+obj.getName()+",instruction="+obj.getInstruction()+",agerestriction"+obj.getAgeRestrict();
            sql = sql.concat("WHERE drugs.id="+obj.getId());
            ResultSet rs = stmt.executeQuery(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }

    public void insert(Drug obj) {
        try {
            String sql = "INSERT INTO drugs(typeid,name,instruction,agerestriction) VALUES (";
            sql = sql.concat(obj.getTypeId() + "," + obj.getName()+","+obj.getInstruction()+","+obj.getAgeRestrict()+")");
            ResultSet rs = stmt.executeQuery(sql);
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
