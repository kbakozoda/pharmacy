package pharmacy.DAO;

import pharmacy.Models.Drug;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrugsDAO extends DAOInterface {

    public DrugsDAO() {
        createConnection();
    }
    private static final String tableName = "drugs";
    Drug fetchDrugFromRs(ResultSet rs) {
        Drug temp = new Drug();
        try {
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setAgeRestrict(rs.getInt("agerestriction"));
            temp.setInstruction(rs.getString("instruction"));
            temp.setTypeId(rs.getInt("typeid"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }

    public List<Drug> getAll() {
        List<Drug> list = new ArrayList<Drug>();
        Drug temp;
        try {
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchDrugFromRs(rs);
                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    public Drug getById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Drug temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchDrugFromRs(rs);
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

    // TODO: remove code duplicates in last two methods in all DAO classes
    public int update(Drug obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            Drug temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateString("name", obj.getName());
                    rs.updateInt("agerestriction", obj.getAgeRestrict());
                    rs.updateString("instruction", obj.getInstruction());
                    rs.updateInt("typeid", obj.getTypeId());
                    rs.updateRow();
                    return 1;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

    public void insert(Drug obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.updateInt("agerestriction", obj.getAgeRestrict());
            rs.updateString("instruction", obj.getInstruction());
            rs.updateInt("typeid", obj.getTypeId());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
