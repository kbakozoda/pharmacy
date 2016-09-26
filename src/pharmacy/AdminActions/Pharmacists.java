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
    private String passwordconf;
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
        int freePhCount = 0;
        phList = phService.getAllForNetwork(networkId);
        phNmbList = new ArrayList<>();
        for (int i=0; i<phList.size(); i++) {
            if (phList.get(i).getPharmacistId() == -1) {
                int temp = phList.get(i).getNumber();
                freePhCount++;
                phNmbList.add(temp);
            }
        }

        if (freePhCount == 0) {
            addActionError("No free pharmacies. Please create new if you want to add new pharmacist");
            return "NOFREE";
        }

        return Action.SUCCESS;
    }

    @SkipValidation
    public String doCreate() {
        int freePhCount = 0;
        if (!regValidate()) {
            phList = phService.getAllForNetwork(networkId);
            phNmbList = new ArrayList<>();
            for (int i=0; i<phList.size(); i++) {
                if (phList.get(i).getPharmacistId() == -1) {
                    int temp = phList.get(i).getNumber();
                    freePhCount++;
                    phNmbList.add(temp);
                }
            }
            if (freePhCount == 0) {
                addActionError("No free pharmacies. Please create new if you want to add new pharmacist");
                return "NOFREE";
            }
            return Action.INPUT;
        } else if (selPh != -1) {
            boolean inlist = false;
            phList = phService.getAllForNetwork(networkId);
            phNmbList = new ArrayList<>();
            for (int i=0; i<phList.size(); i++) {
                if (phList.get(i).getPharmacistId() == -1 && phList.get(i).getNumber() == selPh) {
                    inlist = true;
                    break;
                }
            }

            if (inlist == false) {
                addActionError("The selected pharmacy number does not exist!");
                return Action.INPUT;
            }
        }

        pharmacist.setRole(3);
        uService.insert(pharmacist);
        int uid = uService.getIdByUsername(pharmacist.getUsername());
        System.out.println("uid = " + uid);
        System.out.println("selPH = " + selPh);
        phList = phService.getAllForNetwork(getNetworkId());
        boolean set = false;
        for (int i=0; i<phList.size(); i++) {
            if(phList.get(i).getNumber() == selPh) {
                phList.get(i).setPharmacistId(uid);
                phService.update(phList.get(i));
                set = true;
                break;
            }
        }
        if (!set){
            addActionError("Pharmacy with this number no longer exists");
        }
        return Action.SUCCESS;
    }

    @SkipValidation
    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        pharmacist = uService.getById(id);
        if (pharmacist == null) {
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String doEdit() {
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

    public boolean regValidate() {
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
            return false;
        }

        m = namePattern.matcher(pharmacist.getSurname());
        if(!m.matches())
        {
            addActionError("The surname is invalid");
            return false;
        }

        m = loginPattern.matcher(pharmacist.getUsername());

        for (int i=0; i<ulist.size(); i++) {
            System.out.println(ulist.get(i).getUsername() + " vs " + pharmacist.getUsername());
            System.out.println(ulist.get(i).getRole() + " " + pharmacist.getRole());
            if(ulist.get(i).getUsername().equals(pharmacist.getUsername()) &&
                    ulist.get(i).getRole() == 3 &&
                    ulist.get(i).getId() != pharmacist.getId() ) {
                addActionError("The username is already taken");
                return false;
            }
        }

        if(!m.matches())
        {
            addActionError("The username is invalid");
            return false;
        }

        m = passwordPattern.matcher(pharmacist.getPassword());

        if(!pharmacist.getPassword().equals(passwordconf))
        {
            addFieldError("passwordconf", "Password and its confirmation do not match");
            return false;
        }

        if(!m.matches())
        {
            addFieldError("pharmacist.password", "Such password is invalid");
            return false;
        }

        if(selPh == -1)
        {
            addFieldError("selPh","Please select the pharmacy");
            return false;
        }

        return true;
    }

    public void validate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Pattern loginPattern = ps.getLoginPattern();

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
            System.out.println(ulist.get(i).getUsername() + " vs " + pharmacist.getUsername());
            System.out.println(ulist.get(i).getRole() + " " + pharmacist.getRole());
            if(ulist.get(i).getUsername().equals(pharmacist.getUsername()) &&
                    ulist.get(i).getRole() == 3 &&
                    ulist.get(i).getId() != pharmacist.getId() ) {
                addActionError("The username is already taken");
            }
        }

        if(!m.matches())
        {
            addActionError("The username is invalid");
        }
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

    public int getSelPh() {
        return selPh;
    }

    public void setSelPh(int selPh) {
        this.selPh = selPh;
    }

    public String getPasswordconf() {
        return passwordconf;
    }

    public void setPasswordconf(String passwordconf) {
        this.passwordconf = passwordconf;
    }
}
