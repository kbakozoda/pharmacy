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
    private static final String tableName = "operationhistory";

    HistoryElement fetchHElemFromRs(ResultSet rs) {
        HistoryElement temp;
        temp = new HistoryElement();
        try {
            temp.setId(rs.getInt("id"));
            temp.setNetworkId(rs.getInt("networkid"));
            temp.setDate(rs.getDate("purchasedate"));
            temp.setDrugId(rs.getInt("drugid"));
            temp.setPharmacyId(rs.getInt("pharmacyid"));
            temp.setTotalExpense(rs.getInt("totalexpense"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }


    public List<HistoryElement> getAllFor(int id) {
        List<HistoryElement> list = new ArrayList<HistoryElement>();
        HistoryElement temp;
        try{
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                if (rs.getInt("pharmacyid") == id) {
                    temp = fetchHElemFromRs(rs);
                    list.add(temp);
                }
            }
        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int deleteById(int id) {
        return removeById(id, tableName);
    }
    public int delAllByPhId(int phId) {
        return removeByPhId(phId, tableName);
    }


    public List<HistoryElement> getAll() {
        List<HistoryElement> list = new ArrayList<HistoryElement>();
        HistoryElement temp;
        try{
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchHElemFromRs(rs);
                list.add(temp);
            }
        }catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
