package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.User;

/**
 * Created by User on 06.09.2016.
 */
public class TryAuthorise extends ActionSupport {
    private String username;
    private String password;
    private User user = new User();
    public String execute() {
        //temporary
        if (username.equals("superuser") && password.equals("iamsuperuser")) {
            user.setRole("superuser");
            user.setName("God");
            user.setSurname("Mode");
            user.setUsername(username);
            user.setPassword(password);
            return "SUCCESS-SU";
        } else {
            return "ERROR";
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
}
