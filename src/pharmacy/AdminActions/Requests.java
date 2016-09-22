package pharmacy.AdminActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.Request;
import pharmacy.Models.User;
import pharmacy.Services.PharmacyService;
import pharmacy.Services.RequestService;
import pharmacy.Services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Requests extends ActionSupport implements ModelDriven<Request> {
    private String username;
    private int networkId;

    private Request request;
    private List<Request> list;
    private RequestService service = new RequestService();


    public String execute() {
        username = getUsername();
        networkId = getNetworkId();
        list = new ArrayList<>();
        list = service.getByNwId(networkId);
        System.out.println("listSize="+list.size());
        return Action.SUCCESS;
    }

    public String approve() {
        int id;
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        Request req = service.getById(id);
        List<Request> lst = service.getByPhId(req.getPharmacyId());

        for (int i=0; i<lst.size(); i++) {
            if (lst.get(i).getId() != req.getId()) service.deleteById(lst.get(i).getId());
        }

        User nu = new User();
        nu.setName(req.getName());
        nu.setPassword(req.getPassword());
        nu.setSurname(req.getSurname());
        nu.setUsername(req.getUsername());
        nu.setRole(3);

        UserService userService = new UserService();
        userService.insert(nu);

        int userId = userService.getIdByUsername(nu.getUsername());

        PharmacyService phs = new PharmacyService();
        Pharmacy ph;

        ph = phs.getById(req.getPharmacyId());

        ph.setPharmacistId(userId);
        phs.update(ph);

        service.deleteById(req.getId());



        return Action.SUCCESS;
    }

    public String decline() {
        int id;
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        service.deleteById(id);
        return Action.SUCCESS;
    }

    public Request getModel() {
        return request;
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

    public List<Request> getList() {
        return list;
    }

    public void setList(List<Request> list) {
        this.list = list;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
