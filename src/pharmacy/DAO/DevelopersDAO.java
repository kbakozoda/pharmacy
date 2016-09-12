package pharmacy.DAO;

import pharmacy.Models.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class DevelopersDAO extends DAOInterface{
    public DevelopersDAO() {createConnection();}

    public List<Developer> getAll() {
        List<Developer> list = new ArrayList<Developer>();
        Developer temp;
        try {
            String sql = "SELECT id , name, surname FROM sqltest";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surn = rs.getString("surname");
                temp = new Developer();
                temp.setId(id);
                temp.setName(name);
                temp.setSurname(surn);

                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return list;
    }
}
