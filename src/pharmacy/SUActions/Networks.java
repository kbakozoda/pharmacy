package pharmacy.SUActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.Network;
import pharmacy.Services.NetworkService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11.09.2016.
 */
public class Networks extends ActionSupport implements ModelDriven<Network> {
    List<Network> list;
    NetworkService service = new NetworkService();
    private Network network = new Network();

    public Network getModel() {
        return network;
    }

    public String execute() {
        list = service.getAll();
        return "SUCCESS";
    }

    public String create() {
        return Action.SUCCESS;
    }

    public String doCreate() {
        network.setAdminId(-1);
        service.insert(network);
        return Action.SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        service.deleteById(Integer.parseInt(request.getParameter("id")));
        // TODO: !!! Delete all dependencies (admins, pharmacies, pharmacists, stockcontent)
        return Action.SUCCESS;
    }

    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        network = service.getById(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String update() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        System.out.println("trying to update " + network.getName() + " " + network.getAdminId());
        service.update(network);
        return Action.SUCCESS;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public List<Network> getList() {
        return list;
    }
}
