package pharmacy.Services;

import pharmacy.DAO.RequestDAO;
import pharmacy.Models.Request;

import java.util.List;

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
    public List getAll() {return dao.getAll();}
    public List getByPhId(int id) {return dao.getByPhId(id);}
    public List getByNwId(int id) {return dao.getByNwId(id);}
    public int deleteById(int id) {return dao.deleteById(id);}
    public Request getById(int id) {return dao.getById(id);}
}
