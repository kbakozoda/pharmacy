package pharmacy.DAO;

import pharmacy.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsersDAO extends DAOInterface {
    public UsersDAO() {
        createConnection();
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        User temp;
        try {
            String query = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String password = rs.getString("password");
                int role = rs.getInt("role"); // 1,2,3

                temp = new User();

                temp.setId(id);
                temp.setPassword(password);
                temp.setRole(role);
                temp.setUsername(username);
                temp.setName(name);
                temp.setSurname(surname);
                list.add(temp);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getById(int id) {
        List<User> list = getAll();
        for (User listElement: list) {
            if(listElement.getId() == id) {
                return listElement;
            }
        }
        return null;
    }

    public int deleteById(int id) {
        try {
            String sql = "DELETE FROM users WHERE id=" + id;
            int rs = stmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }

    public int update(User obj) {
        try {
            String sql = "SELECT * FROM networks";
            ResultSet rs = stmt.executeQuery(sql);
            User temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateString("name", obj.getName());
                    rs.updateRow();
                    break;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 1;
    }

    public void insert(User obj) {
        try {
            String sql = "SELECT * FROM networks";
            ResultSet rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
