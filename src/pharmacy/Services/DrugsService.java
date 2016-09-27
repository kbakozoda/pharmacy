package pharmacy.Services;

import pharmacy.DAO.DrugsDAO;
import pharmacy.Models.Drug;

import java.util.List;

public class DrugsService {
    private DrugsDAO dao;

    public DrugsService(){
        dao = new DrugsDAO();
    }

    public int getIdByName(String name) {
        return dao.getIdByName(name);
    }

    public List<Drug> getAll() {
        List<Drug> list;
        list = dao.getAll();
        return list;
    }

    public Drug getById(int id) {
        Drug res;
        res = dao.getById(id);
        return res;
    }

    public int deleteById(int id) {
        return dao.deleteById(id);
    }

    public int update(Drug drug) {
        return dao.update(drug);
    }

    public void insert(Drug drug) {
        dao.insert(drug);
    }

}
