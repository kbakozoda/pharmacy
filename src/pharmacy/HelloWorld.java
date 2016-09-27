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
 *      V Complete all DAO and Services for Admins
 *      V Complete all DAO and Services for Pharmacists
 *      V Change CRUD, Actions into ModelDriven for Drugs & DrugTypes
 *              v add action error messages in every view
 *              v when creating new: check if there are no duplicates
 *      V User info RU
 *      V Complete all actions of Admin with CRUD
 *      V Complete all actions of Pharmacist with CRUD
 *      TODO: onDelete any entity: every dependency must also change it's links
 *              Est: [] Done in[]
 *      V Register new superuser
 *              Est.: [30 min.] Done in[]
 *      V In all pages: add navigation links
 *              Est.: [20 min.] Done in[]
 *      TODO: Everywhere: instead of id's show names/numbers
 *              Est.: [] Done in[]
 *      TODO: On each url with id check if this user has a permission to modify this elem!!!
 *      TODO: Add UserInfo interceptor. Which checks if someone is logged in
 *      TODO: Show username in every page +logout link
 *      TODO: 'Info' -> view each entities data in a separate page
 *      TODO: SU: when u approve 1 request, decline all with the same netwID
 *      TODO: same for Admin
 *      TODO: reg - press submit - form doesn't pass validation - still alerts user.
 *      V Interceptors: check if user still exists
 *              Est.: [10 min.] Done in[]
 *      TODO: Validate all forms +logic validation
 *              Est.: [1.5 h.] Done in[]
 *      TODO: Generate special error messages for these situations & alert them or print on page
 *            Before any action with entity(CRUD or other) check if it still exists.
 *            Update : update only if element still exists;
 *              Est.: [] Done in[]
 *      TODO: Do a security check for every role, every entity
 *         ---------- 3rd lab up until here -------------
 *      V Apply design
 *      TODO: 2. Write junit tests
 *      TODO: 3. Apply file generation classes
 *      TODO: 4. Handle all exceptions when there hasn't been anything fetched from db
 * */
