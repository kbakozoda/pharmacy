package pharmacy.AdminActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.User;
import pharmacy.Services.PatternService;
import pharmacy.Services.PharmacyService;
import pharmacy.Services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Pharmacists extends ActionSupport implements ModelDriven<User> {
    private List<User> list;
    private User pharmacist;
    private PharmacyService phService = new PharmacyService();
    private UserService uService = new UserService();
    private String username = getUsername();
    private int networkId = getNetworkId();
    private int selPh;
    private List<Pharmacy> phList;
    private List phNmbList;

    @SkipValidation
    public String execute() {
        pharmacist = new User();
        list = new ArrayList<User>();
        int phId;
       phList = phService.getAllForNetwork(networkId);

        for (int i=0; i<phList.size(); i++) {
            phId = phList.get(i).getPharmacistId();
            if (phId != -1) {
                list.add(uService.getById(phId));
            }
        }

        return Action.SUCCESS;
    }

    @SkipValidation
    public String create() {
        phList = phService.getAllForNetwork(networkId);
        phNmbList = new ArrayList<>();
        for (int i=0; i<phList.size(); i++) {
            if (phList.get(i).getPharmacistId() == -1) {
                int temp = phList.get(i).getNumber();
                phNmbList.add(temp);
            }
        }
        return Action.SUCCESS;
    }

    public String doCreate() {
        return Action.SUCCESS;
    }

    @SkipValidation
    public String edit() {
        System.out.println("EDIT PHARMACIST");
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("HERE");
        pharmacist = uService.getById(id);
        if (pharmacist == null) {
            return Action.ERROR;
        }
        System.out.println("over here + newid " + networkId );
        phList = phService.getAllForNetwork(networkId);
        phNmbList = new ArrayList<>();
        System.out.println("now here");
        for (int i=0; i<phList.size(); i++) {
            System.out.println("NW:" + phList.get(i).getNumber());
            if (phList.get(i).getPharmacistId() == -1) {
                int temp = phList.get(i).getNumber();
                phNmbList.add(temp);
            } else if (phList.get(i).getPharmacistId() == id) selPh = phList.get(i).getNumber();
        }
        return Action.SUCCESS;
    }

    public String doEdit() {
        if (selPh != -1) {
        }
        uService.update(pharmacist);
        return Action.SUCCESS;
    }

    @SkipValidation
    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        uService.deleteById(id);
        return Action.SUCCESS;
    }

    public void validate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Pattern loginPattern = ps.getLoginPattern();
        Pattern passwordPattern = ps.getPasswordPattern();

        UserService us = new UserService();
        List<User> ulist = us.getAll();

        Matcher m = namePattern.matcher(pharmacist.getName());
        if (!m.matches())
        {
            addActionError("The name is invalid");
        }

        m = namePattern.matcher(pharmacist.getSurname());
        if(!m.matches())
        {
            addActionError("The surname is invalid");
        }

        m = loginPattern.matcher(pharmacist.getUsername());

        for (int i=0; i<ulist.size(); i++) {
            if(ulist.get(i).getUsername().equals(pharmacist.getUsername()) &&
                    ulist.get(i).getId() != pharmacist.getId()) {
                addActionError("The username is already taken");
            }
        }

        if(!m.matches())
        {
            addActionError("The username is invalid");
        }

        phList = new PharmacyService().getAllForNetwork(networkId);
        phNmbList = new ArrayList<>();
        for (int i=0; i<phList.size(); i++) {
            if (phList.get(i).getPharmacistId() == -1) {
                int temp = phList.get(i).getNumber();
                phNmbList.add(temp);
            }
        }
        selPh = phService.getById(pharmacist.getPharmacyId()).getNumber();
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

    public User getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(User pharmacist) {
        this.pharmacist = pharmacist;
    }

    public int getSelPh() {
        return selPh;
    }

    public void setSelPh(int selPh) {
        this.selPh = selPh;
    }

    public List<Pharmacy> getPhList() {
        return phList;
    }

    public void setPhList(List<Pharmacy> phList) {
        this.phList = phList;
    }

    public List getPhNmbList() {
        return phNmbList;
    }

    public void setPhNmbList(List phNmbList) {
        this.phNmbList = phNmbList;
    }
}
