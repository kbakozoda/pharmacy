package pharmacy.Services;

import pharmacy.DAO.DrugsDAO;
import pharmacy.Models.Drug;

import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class DrugsService {
    private List<Drug> drugList;
    private DrugsDAO dao;

    public DrugsService(){
        dao = new DrugsDAO();
    }

    public List<Drug> getAll() {
        List<Drug> list;
        list = dao.getAll();
        return list;
    }
}
