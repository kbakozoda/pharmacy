package pharmacy.Services;

import pharmacy.DAO.StockDAO;
import pharmacy.Models.StockElement;

import java.util.List;

/**
 * Created by User on 22.09.2016.
 */
public class StockService {
    private StockDAO dao;
    public StockService() {
        dao = new StockDAO();
    }

    public List<StockElement> getAll() {
        List<StockElement> list;
        list = dao.getAll();
        return list;
    }

    public List<StockElement> getByPhId(int id) {
        List<StockElement> list;
        list = dao.getByPhId(id);
        System.out.println("elements got: " + list.size());
        return list;
    }
}
