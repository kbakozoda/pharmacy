package pharmacy.Services;

import pharmacy.DAO.NetworkDAO;
import pharmacy.Models.Network;

import java.util.List;

/**
 * Created by User on 04.09.2016.
 */
public class NetworkService {
    List<Network> list;
    NetworkDAO dao;

    public NetworkService() {
        dao = new NetworkDAO();
        list = dao.getAll();
    }

    public List<Network> getList() {
        return list;
    }
}
