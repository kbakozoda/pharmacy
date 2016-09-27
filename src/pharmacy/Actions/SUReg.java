package pharmacy.Actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.validation.SkipValidation;
import pharmacy.Models.User;
import pharmacy.Services.PatternService;
import pharmacy.Services.UserService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SUReg extends ActionSupport implements ModelDriven<User> {
    User user;
    UserService service = new UserService();
    private String passwordconf;

    @SkipValidation
    public String execute() {
        user = new User();
        return Action.SUCCESS;
    }

    public String signUp() {
        user.setRole(1);
        service.insert(user);
        return Action.SUCCESS;
    }

    public void validate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Pattern loginPattern = ps.getLoginPattern();
        Pattern passwordPattern = ps.getPasswordPattern();

        UserService us = new UserService();
        List<User> ulist = us.getAll();

        Matcher m = namePattern.matcher(user.getName());
        if (!m.matches())
        {
            addActionError("The firstname is invalid");
        }

        m = namePattern.matcher(user.getSurname());
        if(!m.matches())
        {
            addActionError("The surname is invalid");
        }

        m = loginPattern.matcher(user.getUsername());

        for (int i=0; i<ulist.size(); i++) {
            if(ulist.get(i).getUsername().equals(user.getUsername())) {
                addActionError("The username is already taken");
            }
        }

        if(!m.matches())
        {
            addActionError("The username is invalid");
        }

        m = passwordPattern.matcher(user.getPassword());

        if(!user.getPassword().equals(passwordconf))
        {
            addActionError("Password and its confirmation do not match");
        }

        if(!m.matches())
        {
            addActionError("Such password is invalid");
        }
    }

    public User getModel() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPasswordconf() {
        return passwordconf;
    }

    public void setPasswordconf(String passwordconf) {
        this.passwordconf = passwordconf;
    }
}
