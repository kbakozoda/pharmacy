package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
//import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import pharmacy.Models.User;
import pharmacy.Services.UserService;

import java.util.Map;

/**
 * Created by User on 06.09.2016.
 */
public class TryAuthorise extends ActionSupport implements SessionAware {
    private String username;
    private String password;
    private User user = new User();
    private UserService service = new UserService();
    private Map<String,Object> session;
    public String execute() {
        user = service.auth(username, password);
        if (user == null) {
            return "ERROR";
        } else {
            session.put("user", user);
            if (user.getRole() == 1) {
                return "SUCCESS-SU";
            } else if (user.getRole() == 2) {
                return "SUCCESS-ADMIN";
            } else {
                return "SUCCESS";
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

    public void setSession(Map session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
