package pharmacy.Interceptors;

import pharmacy.Models.User;

/**
 * Created by User on 04.09.2016.
 */
public interface UserAware {
    public void setUser(User user);
    public User getUser(User user);
}
