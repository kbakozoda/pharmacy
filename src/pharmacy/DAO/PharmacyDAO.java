package pharmacy.DAO;

import pharmacy.AdminActions.Pharmacies;
import pharmacy.Models.Pharmacy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class PharmacyDAO extends DAOInterface {
    public PharmacyDAO() {createConnection();}
    private static final String tableName = "pharmacies";

    Pharmacy fetchPhFromRs(ResultSet rs) {
        Pharmacy temp;
        temp = new Pharmacy();
        try {
            temp.setId(rs.getInt("id"));
            temp.setAddress(rs.getString("address"));
            temp.setPharmacistId(rs.getInt("pharmacistid"));
            temp.setNetworkId(rs.getInt("networkid"));
            temp.setNumber(rs.getInt("number"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }

    public List<Pharmacy> getAll() {
        List<Pharmacy> list = new ArrayList<Pharmacy>();
        Pharmacy temp;
        try{
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchPhFromRs(rs);
                list.add(temp);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List getAllForNetwork(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Pharmacy temp;
        List<Pharmacy> list = new ArrayList<>();
        try {
            while (rs.next()) {
                if (rs.getInt("networkid") == id) {
                    temp = fetchPhFromRs(rs);
                    System.out.println("PhInNw:" + temp.getId());
                    list.add(temp);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }

    public Pharmacy getAllById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        Pharmacy temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchPhFromRs(rs);
                    return temp;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }
    public void insert(Pharmacy obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("address", obj.getAddress());
            rs.updateInt("networkid", obj.getNetworkId());
            rs.updateInt("number", obj.getNumber());
            rs.updateInt("pharmacistid", obj.getPharmacistId());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public int deleteById(int id) {
        return removeById(id, tableName);
    }

    public int update(Pharmacy obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            Pharmacy temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateString("address", obj.getAddress());
                    rs.updateInt("networkid", obj.getNetworkId());
                    rs.updateInt("number", obj.getNumber());
                    rs.updateInt("pharmacistid", obj.getPharmacistId());
                    rs.updateRow();
                    return 1;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

}
