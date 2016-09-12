package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.Drug;
import pharmacy.Services.DrugsService;

import java.util.List;

/**
 * Created by User on 12.09.2016.
 */
public class Drugs extends ActionSupport {
    private DrugsService service;
    List<Drug> list;
    public String execute() {
        service = new DrugsService();
        list = service.getAll();
        return "SUCCESS";
    }

    public List<Drug> getList() {
        return list;
    }
}
