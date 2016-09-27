package pharmacy.DAO;

import pharmacy.Models.StockElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StockDAO extends DAOInterface{
    public StockDAO() {createConnection();}

    private static final String tableName = "stockcontent";

    StockElement fetchNetwFromRs(ResultSet rs) {
        StockElement temp;
        temp = new StockElement();
        try {
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

        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }
    public List<StockElement> getAll() {
        List<StockElement> list = new ArrayList<StockElement>();
        StockElement temp;
        try{
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchNetwFromRs(rs);
                list.add(temp);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public StockElement getById(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        StockElement temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchNetwFromRs(rs);
                    return temp;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public List<StockElement> getByPhId(int id) {
        ResultSet rs = getRSForSelAll(tableName);
        StockElement temp;
        List<StockElement> list = new ArrayList<>();
        try {
            while (rs.next()) {
                if (rs.getInt("pharmacyid") == id) {
                    temp = fetchNetwFromRs(rs);
                    list.add(temp);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return list;
    }
    public int deleteById(int id) {
        return removeById(id, tableName);
    }

    public int update(StockElement obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            StockElement temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateInt("priceofsingle", obj.getPriceOfSingle());
                    rs.updateInt("amount", obj.getAmount());
                    rs.updateRow();
                    return 1;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

    public void insert(StockElement obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateInt("drugid", obj.getDrugId());
            rs.updateInt("amount", obj.getAmount());
            rs.updateInt("pharmacyid", obj.getPharmacyId());
            rs.updateInt("priceofsingle", obj.getPriceOfSingle());
            rs.updateInt("networkid", obj.getNetworkId());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
