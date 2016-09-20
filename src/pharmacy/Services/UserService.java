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
        dao.insert(user);
    }

    public int getIdByUsername(String username) {
        return dao.getIdByUsername(username);
    }

    public User auth(String username, String pass){
        System.out.println("Trying " + username + " " + pass);
        return dao.authenticate(username, pass);
    }
}
