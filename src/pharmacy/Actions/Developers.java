package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pharmacy.Models.Developer;
import pharmacy.Services.DeveloperService;

import java.util.List;

/**
 * Created by User on 05.09.2016.
 */
public class Developers extends ActionSupport {

    private List<Developer> devList;

    public String execute() {
        DeveloperService service = new DeveloperService();
        devList = service.getDevelopers();
        return "SUCCESS";
    }

    public List<Developer> getDevList() {
        System.out.println(devList.get(0).getId() + " " + devList.get(1).getName());
        return devList;
    }

}
