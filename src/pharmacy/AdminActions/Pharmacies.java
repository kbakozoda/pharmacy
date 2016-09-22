package pharmacy.AdminActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.User;
import pharmacy.Services.PharmacyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class Pharmacies extends ActionSupport implements ModelDriven<Pharmacy> {

    private String username;
    private int networkId;

    private Pharmacy pharmacy;
    private List<Pharmacy> list;
    private PharmacyService service = new PharmacyService();
    public String execute() {
        username = getUsername();
        networkId = getNetworkId();
        // TODO: Error if networkid is not detected
        list = service.getAllForNetwork(networkId);

        return Action.SUCCESS;
    }

    public String create() {
        pharmacy = new Pharmacy();
        return Action.SUCCESS;
    }

    public String doCreate() {
        pharmacy.setNetworkId(getNetworkId());
        pharmacy.setPharmacistId(-1);

        PharmacyService serv = new PharmacyService();
        serv.insert(pharmacy);
        return Action.SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        PharmacyService service = new PharmacyService();
        int res = service.deleteById(id);

        if (res == 1) return Action.SUCCESS;

        else return Action.ERROR;

    }

    public Pharmacy getModel() {
        return pharmacy;
    }

    public String getUsername() {
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");

        return user.getUsername();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public int getNetworkId() {
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");

        return user.getNetworkdId();
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
