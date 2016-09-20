package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.Request;
import pharmacy.Models.User;
import pharmacy.Services.PatternService;
import pharmacy.Services.PharmacyService;
import pharmacy.Services.RequestService;
import pharmacy.Services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 20.09.2016.
 */
public class PhSignUp extends ActionSupport {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String passwordconf;
    private List<Pharmacy> phList;
    private List phNmbList;
    private int selPh;

    public String execute() {
        RequestService rservice = new RequestService();
        PharmacyService phservice = new PharmacyService();
        List<Pharmacy> plst = phservice.getAll();
        int phid = -1 , nwid = -1;

        for (int i=0; i<plst.size(); i++) {
            if(plst.get(i).getNumber() == selPh){
                phid = plst.get(i).getId();
                nwid = plst.get(i).getNetworkId();
            }
        }

        if (phid == -1) return "ERROR";

        Request req = new Request();

        req.setNetworkId(nwid);
        req.setPharmacyId(phid);
        req.setName(name);
        req.setUsername(username);
        req.setPassword(password);
        req.setSurname(surname);

        rservice.insert(req);
        return "SUCCESS";
    }

    public void validate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Pattern loginPattern = ps.getLoginPattern();
        Pattern passwordPattern = ps.getPasswordPattern();

        UserService us = new UserService();
        List<User> ulist = us.getAll();

        Matcher m = namePattern.matcher(name);
        if (!m.matches())
        {
            addFieldError("name", "The firstname is invalid");
        }

        m = namePattern.matcher(surname);
        if(!m.matches())
        {
            addFieldError("surname", "The surname is invalid");
        }

        m = loginPattern.matcher(username);

        for (int i=0; i<ulist.size(); i++) {
            if(ulist.get(i).getUsername().equals(username)) {
                addFieldError("username", "The username is already taken");
            }
        }

        if(!m.matches())
        {
            addFieldError("username", "The username is invalid");
        }

        m = passwordPattern.matcher(password);

        if(!password.equals(passwordconf))
        {
            addFieldError("passwordconf", "Password and its confirmation do not match");
        }

        if(!m.matches())
        {
            addFieldError("password", "Such password is invalid");
        }

        if(selPh == -1)
        {
            addFieldError("selPh","Please select the network");
        }

        phList = new PharmacyService().getAll();
        phNmbList = new ArrayList<>();
        for (int i=0; i<phList.size(); i++) {
            if (phList.get(i).getPharmacistId() == -1) {
                int temp = phList.get(i).getNumber();
                phNmbList.add(temp);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
