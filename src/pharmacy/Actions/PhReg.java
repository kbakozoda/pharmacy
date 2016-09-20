package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.Pharmacy;
import pharmacy.Services.PharmacyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.09.2016.
 */
public class PhReg extends ActionSupport {
    private String username;
    private String password;
    private String confpassword;
    private String name;
    private String surname;
    private List<Pharmacy> phList;
    private List phNmbList;
    private int selPh;

    public String execute() {
        phList = new PharmacyService().getAll();
        phNmbList = new ArrayList<>();
        int freePhCount = 0;
        for (int i=0; i<phList.size(); i++) {
            if (phList.get(i).getPharmacistId() == -1) {
                freePhCount ++;
                int temp = phList.get(i).getNumber();
                phNmbList.add(temp);
            }
        }

        if(freePhCount == 0) return "NOFREE";
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
}
