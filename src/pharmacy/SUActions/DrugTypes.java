package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.DAO.DrugTypesDAO;
import pharmacy.Models.DrugType;

import java.util.List;

/**
 * Created by User on 13.09.2016.
 */
public class DrugTypes extends ActionSupport {
    private DrugTypesDAO dao;
    List list;
    public String execute() {
        dao = new DrugTypesDAO();
        list = dao.getAll();

        if (list == null){
            return "ERROR";
        }
        return "SUCCESS";
    }

    public List getList() {
        return list;
    }
}
