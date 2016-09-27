package pharmacy.PhActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import javafx.util.Pair;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.Drug;
import pharmacy.Models.StockElement;
import pharmacy.Models.User;
import pharmacy.Services.DrugsService;
import pharmacy.Services.PharmacyService;
import pharmacy.Services.StockService;

import javax.servlet.http.HttpServletRequest;
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
    private List selectDrug;
    private String selected;
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

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        // TODO check if this id really belongs to this user. in edit too;

        service.deleteById(id);
        return Action.SUCCESS;
    }

    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        setUsernameAndPhId();
        // TODO check if this stock element belongs to this pharmacist.
        stockElement = service.getById(id);
        if (stockElement == null) {
            return Action.ERROR;
        }
        System.out.println(stockElement.getAmount() + " " + stockElement.getPriceOfSingle());
        return Action.SUCCESS;
    }

    public String doEdit() {
        if (service.update(stockElement) == 1) {
            return Action.SUCCESS;
        }
        return Action.ERROR;
    }

    public String create() {
        /*stockElement = new StockElement();
        selectDrug = new ArrayList<String>();
        DrugsService ds = new DrugsService();
        List<Drug> drugList = ds.getAll();
        boolean found;
        // getting list of drugs that are not in stock content and in parallel collecting their names
        for (int i=0; i<drugList.size(); i++) {
            found = false;
            for (int j=0; j<list.size(); i++) {
                if (list.get(j).getDrugId() == drugList.get(i).getId()) {
                    found = true;
                    break;
                }
            }
            if (found) drugList.remove(i);
            else selectDrug.add(drugList.get(i).getName());
        }*/
        return Action.SUCCESS;
    }

    public String doCreate() {
        return Action.SUCCESS;
    }

    public void setUsernameAndPhId() {
        // TODO collect all info here, list of all content for user. if user is not in the session ther return error
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

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public List getSelectDrug() {
        return selectDrug;
    }

    public void setSelectDrug(List selectDrug) {
        this.selectDrug = selectDrug;
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

    public StockElement getStockElement() {
        return stockElement;
    }

    public void setStockElement(StockElement stockElement) {
        this.stockElement = stockElement;
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
