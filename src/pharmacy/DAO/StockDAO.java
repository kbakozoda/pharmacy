package pharmacy.DAO;

import pharmacy.Models.StockElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// TODO think of how to remove all this routine code in all DAOs. apply polymorphism

// for Pharmacists

public class StockDAO extends DAOInterface{
    public StockDAO() {createConnection();}

    public List<StockElement> executeSQLQ(String query){
        List<StockElement> list = new ArrayList<StockElement>();
        StockElement temp;
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int drugid = rs.getInt("drugid");
                int price = rs.getInt("priceofsingle");
                int pharmid = rs.getInt("pharmacyid");
                int netw = rs.getInt("networkid");
                int amount = rs.getInt("amount");
                temp = new StockElement();
                temp.setId(id);
                temp.setNetworkId(netw);
                temp.setAmount(amount);
                temp.setDrugId(drugid);
                temp.setPharmacyId(pharmid);
                temp.setPriceOfSingle(price);

                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<StockElement> getAll() {
        String sql = "SELECT * FROM stockcontent";
        return executeSQLQ(sql);
    }

    public List<StockElement> getAllForPharmacy(int id) {
        String sql = "SELECT * FROM pharmacies WHERE pharmacyid="+id;
        return executeSQLQ(sql);
    }
}
