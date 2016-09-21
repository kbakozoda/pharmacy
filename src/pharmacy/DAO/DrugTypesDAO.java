package pharmacy.DAO;

import pharmacy.Models.DrugType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugTypesDAO extends DAOInterface {
    public DrugTypesDAO() {createConnection();}

    private static final String tableName = "drugtypes";

    DrugType fetchDTypeFromRs(ResultSet rs) {
        DrugType temp = new DrugType();
        try {
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }

    public List<DrugType> getAll() {
        List<DrugType> list = new ArrayList<DrugType>();
        DrugType temp;
        try {
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchDTypeFromRs(rs);
                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean isNameTaken(String name) {
        ResultSet rs = getRSForSelAll(tableName);
        try {
            while (rs.next()) {
                if (rs.getString("name").equals(name)) {
                    return true;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    public DrugType getById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        DrugType temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchDTypeFromRs(rs);
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

    public int update(DrugType obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            DrugType temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateString("name", obj.getName());
                    rs.updateRow();
                    return 1;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

    public void insert(DrugType obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
