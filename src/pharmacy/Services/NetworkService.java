package pharmacy.Services;

import pharmacy.DAO.NetworkList;
import pharmacy.Models.Network;

import java.util.List;

/**
 * Created by User on 04.09.2016.
 */
public class NetworkService {
    List<Network> list;
    NetworkList db;

    public NetworkService() {
        db = new NetworkList();
        list = db.getAll();
    }

    public List<Network> getList() {
        return list;
    }
}
