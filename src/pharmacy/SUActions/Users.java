package pharmacy.SUActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.User;
import pharmacy.Services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Users extends ActionSupport {
    private List<User> list;
    UserService us = new UserService();

    public String execute() {
        list = new ArrayList<User>();
        List<User> all = us.getAll();
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");
        for (int i=0; i<all.size(); i++) {
            if (all.get(i).getId() != user.getId()) {
                list.add(all.get(i));
            }
        }
        return Action.SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int res = us.deleteById(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
