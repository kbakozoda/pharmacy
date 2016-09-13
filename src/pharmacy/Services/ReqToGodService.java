package pharmacy.Services;

import pharmacy.DAO.SURequestDAO;
import pharmacy.Models.RequestToGod;

import java.util.List;

/**
 * Created by User on 10.09.2016.
 */
public class ReqToGodService {
    List<RequestToGod> list;
    SURequestDAO dao;

    public ReqToGodService() {
        dao = new SURequestDAO();
        list = dao.getAll();
    }

    public List<RequestToGod> getSURequests() {
        return list;
    }
}
