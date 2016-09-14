package pharmacy.Services;

import pharmacy.DAO.UsersDAO;
import pharmacy.Models.User;

import java.util.List;

/**
 * Created by User on 14.09.2016.
 */
public class UserService {
    UsersDAO dao;

    public UserService() {
        dao = new UsersDAO();
    }

    public List<User> getAll() {
        List<User> list;
        list = dao.getAll();
        return list;
    }

    public User getById(int id) {
        User res;
        res = dao.getById(id);
        return res;
    }

    public int deleteById(int id) {
        return dao.deleteById(id);
    }

    public int update(User user) {
        return dao.update(user);
    }

    public void insert(User user) {
        // This method is only used when SU or Admin approves request. Not for signed up ones;
        // Create new methods for them; and check for uniqueness of usernames
        dao.insert(user);
    }

    public int getIdByUsername(String username) {
        return 0;
    }
}
