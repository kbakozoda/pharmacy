package pharmacy.Services;

import pharmacy.DAO.SURequestsList;
import pharmacy.Models.RequestToGod;

import java.util.List;

/**
 * Created by User on 10.09.2016.
 */
public class ReqToGodService {
    List<RequestToGod> list;
    SURequestsList db = new SURequestsList();

    public List<RequestToGod> getSURequests() {
        return list;
    }
}
