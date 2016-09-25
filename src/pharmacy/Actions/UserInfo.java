package pharmacy.Actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.validation.SkipValidation;
import pharmacy.Models.User;
import pharmacy.Services.PatternService;
import pharmacy.Services.UserService;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 25.09.2016.
 */
public class UserInfo extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private Map session;
    private UserService service = new UserService();

    private String oldPass;
    private String newPass;
    private String newPassConf;

    @SkipValidation
    public String execute() {
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        return Action.SUCCESS;
    }

    @SkipValidation
    public String credentials() {
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        return Action.SUCCESS;
    }

    public String crUpdate() {
        session = ActionContext.getContext().getSession();
        service.update(user);
        session.remove("user");
        session.put("user", user);
        return Action.SUCCESS;
    }

    @SkipValidation
    public String pass() {
        return Action.SUCCESS;
    }

    @SkipValidation
    public String updPass() {
        session = ActionContext.getContext().getSession();
        if (passValidate()) {
            user.setPassword(newPass);
            service.update(user);
            session.remove("user");
            session.put("user", user);
        } else {
            return Action.INPUT;
        }
        return Action.SUCCESS;
    }

    @SkipValidation
    public String redirect() {
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");

        switch (user.getRole()) {
            case 1: return "SU";
            case 2: return "ADMIN";
            case 3: return "PH";
            default: return "ERROR";
        }
    }

    public boolean passValidate() {
        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");

        if (!oldPass.equals(user.getPassword())) {
            addActionError("ERROR: don't you know your current password? Suspicious..but ok.");
            return false;
        } else if (!newPass.equals(newPassConf)){
            addActionError("ERROR: new password and it's confirmation don't match. Please make sure they are same.");
            return false;
        } else {
            PatternService ps = new PatternService();
            Pattern passwordPattern = ps.getPasswordPattern();
            Matcher m = passwordPattern.matcher(newPass);
            if(!m.matches())
            {
                addActionError("Such password is invalid");
                return false;
            }
        }
        return true;
    }

    public void validate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Pattern loginPattern = ps.getLoginPattern();

        List<User> ulist = service.getAll();

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
            if(ulist.get(i).getUsername().equals(user.getUsername()) &&
                    ulist.get(i).getId() != user.getId()) {
                addActionError("The username is already taken");
            }
        }

        if(!m.matches())
        {
            addActionError("The username is invalid");
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

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewPassConf() {
        return newPassConf;
    }

    public void setNewPassConf(String newPassConf) {
        this.newPassConf = newPassConf;
    }
}
