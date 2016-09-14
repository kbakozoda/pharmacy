package pharmacy.Services;

import pharmacy.DAO.SURequestDAO;
import pharmacy.DAO.UsersDAO;
import pharmacy.Models.Network;
import pharmacy.Models.RequestToGod;
import pharmacy.Models.User;

/**
 * Created by User on 14.09.2016.
 */
public class SURequestService {
    SURequestDAO dao;

    public SURequestService() {
        dao = new SURequestDAO();
    }

    public void approveById(int id) {
        RequestToGod temp;
        temp = dao.getById(id);

        User nu = new User();
        nu.setName(temp.getName());
        nu.setPassword(temp.getPassword());
        nu.setSurname(temp.getSurname());
        nu.setUsername(temp.getUsername());
        nu.setRole(2);

        UserService userService = new UserService();
        userService.insert(nu);
        int userId = userService.getIdByUsername(nu.getUsername());

        NetworkService networkService = new NetworkService();
        Network netw;
        netw = networkService.getById(temp.getNetworkId());

        netw.setAdminId(userId);
        networkService.update(netw);
        // check for correctness
    }

    public void declineById(int id) {
        dao.deleteById(id);
    }

}
