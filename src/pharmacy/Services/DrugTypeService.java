package pharmacy.Services;

import pharmacy.DAO.DrugTypesDAO;
import pharmacy.Models.DrugType;

import java.util.List;

public class DrugTypeService {
    DrugTypesDAO dao;
    public DrugTypeService() {
        dao  = new DrugTypesDAO();
    }

    public List<DrugType> getAll() {
        List<DrugType> list;
        list = dao.getAll();
        return list;
    }

    public boolean isThereByName(String name) {
        List<DrugType> list;
        return dao.isNameTaken(name);
    }

    public DrugType getById(int id) {
        DrugType res;
        res = dao.getById(id);
        return res;
    }

    public int deleteById(int id) {
        return dao.deleteById(id);
    }

    public int update(DrugType dt) {
        return dao.update(dt);
    }

    public void insert(DrugType dt) {
        dao.insert(dt);
    }
}
