package pharmacy.AdminActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.User;
import pharmacy.Services.PharmacyService;
import pharmacy.Services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Pharmacists extends ActionSupport implements ModelDriven<User> {
    private List<User> list;
    private User pharmacist;
    private PharmacyService phService = new PharmacyService();
    private UserService uService = new UserService();
    private String username;
    private int networkId;

    public String execute() {
        pharmacist = new User();
        list = new ArrayList<User>();
        networkId = getNetworkId();
        username = getUsername();
        int phId;
        List <Pharmacy> phList = phService.getAllForNetwork(networkId);

        for (int i=0; i<phList.size(); i++) {
            phId = phList.get(i).getPharmacistId();
            if (phId != -1) {
                list.add(uService.getById(phId));
            }
        }

        return Action.SUCCESS;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public User getModel() {
        return pharmacist;
    }

    public String getUsername() {
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");

        return user.getUsername();
    }

    public int getNetworkId() {
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");

        return user.getNetworkdId();
    }
}
