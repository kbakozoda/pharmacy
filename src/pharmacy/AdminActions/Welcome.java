package pharmacy.AdminActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.User;
import pharmacy.Services.NetworkService;

import java.util.Map;

/**
 * Created by User on 06.09.2016.
 */

public class Welcome extends ActionSupport{
    private String username;
    private User user;
    public String execute()
    {
        Map session = ActionContext.getContext().getSession();
        user = (User) session.get("user");
        username = user.getUsername();

        NetworkService nservice = new NetworkService();
        user.setNetworkdId(nservice.getByAdminId(user.getId()).getId());

        session.remove("user");
        session.put("user", user);
        System.out.println(user.getUsername() + " " + user.getId() + " " + user.getNetworkdId());
        return Action.SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
