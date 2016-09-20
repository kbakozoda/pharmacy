package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.DAO.SURequestDAO;
import pharmacy.Models.Network;
import pharmacy.Models.RequestToGod;
import pharmacy.Models.User;
import pharmacy.Services.NetworkService;
import pharmacy.Services.PatternService;
import pharmacy.Services.SURequestService;
import pharmacy.Services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 20.09.2016.
 */
public class AdminSignUp extends ActionSupport {
    public String username;
    public String password;
    public String passwordconf;
    public String name;
    public String surname;
    public String selNetw;
    private List<Network> netwList;
    private List<String> netwNameList;

    public String execute() {
        SURequestService suservice = new SURequestService();
        NetworkService ns = new NetworkService();
        List<Network> ntwList = ns.getAll();
        int id = -1;
        for (int i=0; i<netwList.size(); i++){
            if (netwList.get(i).getName().equals(selNetw)) {
                id = netwList.get(i).getId();
                break;
            }
        }
        if (id == -1) return "ERROR"; // this must never happen

        RequestToGod req = new RequestToGod();
        req.setName(name);
        req.setSurname(surname);
        req.setUsername(username);
        req.setPassword(password);
        req.setNetworkId(id);
        suservice.insert(req);
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

        if(selNetw.equals("nll") || selNetw == null)
        {
            addFieldError("selNetw","Please select the network");
        }

        netwList = new NetworkService().getAll();
        netwNameList = new ArrayList<String>();
        for (int i=0; i<netwList.size(); i++) {
            String temp = netwList.get(i).getName();
            netwNameList.add(temp);
        }

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordconf() {
        return passwordconf;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSelNetw() {
        return selNetw;
    }

    public List<Network> getNetwList() {
        return netwList;
    }

    public void setNetwList(List<Network> netwList) {
        this.netwList = netwList;
    }

    public List<String> getNetwNameList() {
        return netwNameList;
    }

    public void setNetwNameList(List<String> netwNameList) {
        this.netwNameList = netwNameList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSelNetw(String selNetw) {
        this.selNetw = selNetw;
    }
}
