package pharmacy.Interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.omg.PortableInterceptor.Interceptor;
import pharmacy.Models.User;

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
        System.out.println("inside SUauth interceptor");
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get("user");

        if(user == null || user.getRole() != 1){
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
