package pharmacy;

/**
 * Created by User on 02.09.2016.
 */
public class HelloWorld {
    private String username;
    private String greeting;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String execute() {
        setGreeting("Hello " + getUsername());
        return "SUCCESS";
    }
}
/** TODO Sequence:
 *      V Complete all DAO of SU entities
 *      V Write services for all SU entities
 *      V Change login in index.jsp to GOTO MY DASHBOARD
 *      V Make authorisation interceptors
 *      V Complete login action, with role detection
 *      V Logout action.
 *      V Complete registration actions.
 *      TODO: 2. Complete all DAO and Services for Admins
 *      TODO: 3. Complete all DAO and Services for Pharmacists
 *      TODO: 4. Complete Edit actions for Drugs & DrugTypes
 *      --> Complete all actions of Admin with CRUD
 *      TODO: 6. Complete all actions of Pharmacist with CRUD
 *      TODO: 7. In all pages: add links to previous ones.
 *         ---------- 3rd lab up until here -------------
 *      TODO: 7. Apply design
 *      TODO: 8. Write junit tests
 *      TODO: 9. Apply file generation classes
 *      TODO: 10. Handle all exceptions when there hasn't been anything fetched from db
 * */
