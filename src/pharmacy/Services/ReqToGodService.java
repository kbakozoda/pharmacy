package pharmacy.Services;

import pharmacy.DAO.SURequestsList;
import pharmacy.Models.RequestToGod;

import java.util.List;

/**
 * Created by User on 10.09.2016.
 */
public class ReqToGodService {
    List<RequestToGod> list;
    SURequestsList db;

    public ReqToGodService() {
        db = new SURequestsList();
        list = db.getList();
    }

    public List<RequestToGod> getSURequests() {
        return list;
    }
}
