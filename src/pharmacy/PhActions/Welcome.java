package pharmacy.PhActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import javafx.util.Pair;
import pharmacy.Models.StockElement;
import pharmacy.Models.User;
import pharmacy.Services.DrugsService;
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
    private List<Pair<String, StockElement>> listwithnames;
    public String execute() {
        setUsernameAndPhId();
        list = service.getByPhId(phId);
        DrugsService drService = new DrugsService();
        String temp;
        listwithnames = new ArrayList<Pair<String, StockElement>>();
        for (int i=0; i<list.size(); i++) {
            temp = drService.getById(list.get(i).getDrugId()).getName();
            listwithnames.add(new Pair<String, StockElement>(temp, list.get(i)));
        }
        return Action.SUCCESS;
    }

    public void setUsernameAndPhId() {
        Map session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        username = user.getUsername();
        PharmacyService phservice = new PharmacyService();
        System.out.println("uid = " + user.getId() + " gebpi = "+ phservice.getByPhId(user.getId()));
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

    public List<Pair<String, StockElement>> getListwithnames() {
        return listwithnames;
    }

    public void setListwithnames(List<Pair<String, StockElement>> listwithnames) {
        this.listwithnames = listwithnames;
    }

    public String getUsername() {
        return username;
    }

    public int getPhId() {
        return phId;
    }
}
