package pharmacy.Services;

import pharmacy.DAO.PharmacyDAO;

import java.util.List;

/**
 * Created by User on 20.09.2016.
 */
public class PharmacyService {
    PharmacyDAO dao;

    public PharmacyService() {
        dao = new PharmacyDAO();
    }

    public List getAll() {
       List list = dao.getAll();
        return list;
    }
}
