package pharmacy.Interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.omg.PortableInterceptor.Interceptor;
import pharmacy.Models.User;
import pharmacy.Services.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 06.09.2016.
 */
// SuperUser Authorisation Interceptor
public class SUAuthInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = -5011962009065225959L;

    public void destroy(){

    }

    public void init(){

    }


    public String intercept(ActionInvocation actionInvocation)
            throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get("user");
        UserService us = new UserService();
        List<User> users = us.getAll();
        boolean found = false;
        if (user != null) {
            for (int i=0; i<users.size(); i++) {
                if (users.get(i).getUsername().equals(user.getUsername())) {
                    found = true;
                    break;
                }
            }
        }

        if(found == false || user.getRole() != 1){
            session.remove("user");
            return "LOGIN";
        }else{
            Action action = (Action) actionInvocation.getAction();
            if(action instanceof UserAware){
                ((UserAware) action).setUser(user);
            }
            return actionInvocation.invoke();
        }
    }
}
