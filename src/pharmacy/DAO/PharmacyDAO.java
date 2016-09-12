package pharmacy.DAO;

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

    public List<Pharmacy> executeSQLQ(String query){
        List<Pharmacy> list = new ArrayList<Pharmacy>();
        Pharmacy temp;
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int netwid = rs.getInt("networkid");
                int number = rs.getInt("number");
                int pharmacistid = rs.getInt("pharmacistid");
                String address = rs.getString("address");

                temp = new Pharmacy();

                temp.setId(id);
                temp.setNetworkId(netwid);
                temp.setAddress(address);
                temp.setNumber(number);
                temp.setPharmacistId(pharmacistid);

                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Pharmacy> getAll() {
        String sql = "SELECT * FROM pharmacies";
        return executeSQLQ(sql);
    }

    public List<Pharmacy> getAllForNetwork(int id) {
        String sql = "SELECT * FROM pharmacies WHERE networkid="+id;
        return executeSQLQ(sql);
    }

}
