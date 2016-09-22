package pharmacy.Services;

import pharmacy.DAO.HistoryDAO;

import java.util.List;

/**
 * Created by User on 22.09.2016.
 */
public class HistoryService {
    private HistoryDAO dao;
    public HistoryService() {
        dao = new HistoryDAO();
    }

    public List getAll() {
        List list = dao.getAll();
        return list;
    }

    public List getAllByPh(int id) {
        List list = dao.getAllFor(id);
        return list;
    }
}
