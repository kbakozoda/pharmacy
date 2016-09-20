package pharmacy.Services;

import pharmacy.DAO.RequestDAO;
import pharmacy.Models.Request;

/**
 * Created by User on 20.09.2016.
 */
public class RequestService {
    RequestDAO dao;

    public RequestService() {
        dao = new RequestDAO();
    }

    public void insert(Request req) {
        dao.insert(req);
    }
}
