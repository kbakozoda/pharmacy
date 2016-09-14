package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.Network;
import pharmacy.Services.NetworkService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11.09.2016.
 */
public class Networks extends ActionSupport {
    List<Network> list;
    NetworkService service;
    public String execute() {
        service = new NetworkService();
        list = service.getAll();
        return "SUCCESS";
    }

    public List<Network> getList() {
        return list;
    }
}
