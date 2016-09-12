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

}
