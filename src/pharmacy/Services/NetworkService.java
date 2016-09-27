package pharmacy.Services;

import pharmacy.DAO.NetworkDAO;
import pharmacy.Models.Network;

import java.util.List;

public class NetworkService {
    NetworkDAO dao;
    public NetworkService() {
        dao = new NetworkDAO();
    }

    public List<Network> getAll() {
        List<Network> list;
        list = dao.getAll();
        return list;
    }

    public Network getById(int id) {
        Network res;
        res = dao.getById(id);
        return res;
    }

    public Network getByAdminId(int id) {
        Network res;
        res = dao.getByAdminId(id);
        return res;
    }


    public int deleteById(int id) {
        return dao.deleteById(id);
    }

    public int update(Network nw) {
        return dao.update(nw);
    }

    public void insert(Network nw) {
        dao.insert(nw);
    }


}
