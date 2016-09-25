package pharmacy.PhActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import pharmacy.Models.StockElement;
import pharmacy.Models.User;
import pharmacy.Services.PharmacyService;
import pharmacy.Services.StockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 06.09.2016.
 */
public class Welcome extends ActionSupport implements ModelDriven<StockElement>{
    private StockElement stockElement = new StockElement();
    private StockService service = new StockService();
    private List<StockElement> list = new ArrayList<>();
    private User user;
    private String username;
    private int phId;
    public String execute() {
        setUsernameAndPhId();
        list = service.getByPhId(phId);
        return Action.SUCCESS;
    }

    public void setUsernameAndPhId() {
        Map session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        username = user.getUsername();

        PharmacyService phservice = new PharmacyService();
        user.setPharmacyId(phservice.getByPhId(user.getId()).getId());
        phId = user.getPharmacyId();

        session.remove("user");
        session.put("user", user);
        System.out.println(user.getUsername() + " " + user.getPharmacyId());
    }

    public List<StockElement> getList() {
        return list;
    }

    public void setList(List<StockElement> list) {
        this.list = list;
    }

    public StockElement getModel() {
        return stockElement;
    }
}
