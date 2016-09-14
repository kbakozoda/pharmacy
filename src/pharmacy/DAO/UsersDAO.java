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

    private static final String tableName = "users";

    User fetchUserFromRs(ResultSet rs) {
        User temp = new User();
        try {
            temp.setId(rs.getInt("id"));
            temp.setPassword(rs.getString("password"));
            temp.setRole(rs.getInt("role")); // 1,2,3
            temp.setUsername(rs.getString("username"));
            temp.setName(rs.getString("name"));
            temp.setSurname(rs.getString("surname"));
        }catch (SQLException se) {
            se.printStackTrace();
        }
        return temp;
    }
    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        User temp;
        try {
            ResultSet rs = getRSForSelAll(tableName);
            while (rs.next()) {
                temp = fetchUserFromRs(rs);
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
        ResultSet rs = getRSForSelAll(tableName);
        User temp;
        try {
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    temp = fetchUserFromRs(rs);
                    return temp;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public int deleteById(int id) {
        return removeById(id, tableName);
    }

    public int update(User obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            User temp;
            while (rs.next()) {
                if (rs.getInt("id") == obj.getId()) {
                    rs.updateString("name", obj.getName());
                    rs.updateString("surname", obj.getSurname());
                    rs.updateString("password", obj.getPassword());
                    rs.updateString("username", obj.getUsername());
                    rs.updateInt("role", obj.getRole());
                    rs.updateRow();
                    return 1;
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

    public void insert(User obj) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            rs.moveToInsertRow();
            rs.updateString("name", obj.getName());
            rs.updateString("surname", obj.getSurname());
            rs.updateString("password", obj.getPassword());
            rs.updateString("username", obj.getUsername());
            rs.updateInt("role", obj.getRole());
            rs.insertRow();
        }catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public int getIdByUsername(String username) {
        try {
            ResultSet rs = getRSForSelAll(tableName);
            while(rs.next()) {
                if (rs.getString("username").equals(username)) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return -1;
    }
}
