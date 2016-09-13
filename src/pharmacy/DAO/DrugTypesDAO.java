package pharmacy.DAO;

import pharmacy.Models.DrugType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugTypesDAO extends DAOInterface {
    public DrugTypesDAO() {createConnection();}

    public List<DrugType> getAll() {
        List<DrugType> list = new ArrayList<DrugType>();
        DrugType temp;
        try {
            String sql = "SELECT * FROM drugtypes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                temp = new DrugType();
                temp.setId(id);
                temp.setName(name);
                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DrugType getById(int id) {
        List<DrugType> list = getAll();
        for (DrugType listElement: list) {
            if(listElement.getId() == id) {
                return listElement;
            }
        }
        return null;
    }

    public int deleteById(int id) {
        try {
            String sql = "DELETE FROM drugtypes WHERE id=" + id;
            int rs = stmt.executeUpdate(sql);
            // TODO: learn how to get result of query execution, and check whether result is successful. EVERYWHERE!!!
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }

    public int update(DrugType obj) {
        try {
            String sql = "UPDATE drugs SET name='"+obj.getName()+"'";
            sql = sql.concat("WHERE id="+obj.getId());
            int rs = stmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }

    public void insert(DrugType obj) {
        try {
            String sql = "INSERT INTO drugtypes (name) VALUES('" + obj.getName() +"')";
            int rs = stmt.executeUpdate(sql);
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
