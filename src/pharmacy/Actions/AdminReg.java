package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;
import pharmacy.Models.Network;
import pharmacy.Services.NetworkService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.09.2016.
 */
public class AdminReg extends ActionSupport {
    private String username;
    private String password;
    private String confpassword;
    private String name;
    private String surname;
    private List<Network> netwList;
    private List<String> netwNameList;
    private String selNetw;

    public String execute() {
        netwList = new NetworkService().getAll();
        netwNameList = new ArrayList<String>();
        int freeNetworksCount = 0;
        for (int i=0; i<netwList.size(); i++) {
            if (netwList.get(i).getAdminId() == -1) {
                freeNetworksCount ++;
                String temp = netwList.get(i).getName();
                netwNameList.add(temp);
            }
        }

        if(freeNetworksCount == 0) return "NOFREE";
        return "SUCCESS";
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

    public String getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
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

    public String getSelNetw() {
        return selNetw;
    }

    public void setSelNetw(String selNetw) {
        this.selNetw = selNetw;
    }

}
