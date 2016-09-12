package pharmacy.DAO;

import pharmacy.Models.HistoryElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class HistoryDAO extends DAOInterface{
    public HistoryDAO() {
        createConnection();
    }

    public List<HistoryElement> executeSQLQ(String query){
        List<HistoryElement> list = new ArrayList<HistoryElement>();
        HistoryElement temp;
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int netwid = rs.getInt("networkid");
                int pharmid = rs.getInt("pharmacyid");
                int drugid = rs.getInt("drugid");
                int expense = rs.getInt("totalexpense");
                Date date = rs.getDate("purchasedate");
                temp = new HistoryElement();
                temp.setId(id);
                temp.setNetworkId(netwid);
                temp.setDate(date);
                temp.setDrugId(drugid);
                temp.setPharmacyId(pharmid);
                temp.setTotalExpense(expense);
                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HistoryElement> getAllFor(int id) {
        String sql = "SELECT * FROM operationhistory WHERE networkid=" + id;
        return executeSQLQ(sql);
    }
    public List<HistoryElement> getAll() {
        String sql = "SELECT * FROM operationhistory";
        return executeSQLQ(sql);
    }
}
