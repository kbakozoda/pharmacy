package pharmacy.Actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by User on 04.09.2016.
 */
public class Login extends ActionSupport {
    public String execute() {
        return "SUCCESS";
    }

    public String logout() {
        Map session = ActionContext.getContext().getSession();
        session.remove("user");
        return "SUCCESS";
    }
}
