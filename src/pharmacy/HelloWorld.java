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
 *      1. Complete all DAO of SU entities
 *      2. Make authorisation interceptor
 *      2.2 Complete login action, with role detection
 *      3. Complete all actions of SU with CRUD methods, make sure they work correctly
 *      4. Complete all DAO for Admin entities
 *      5. Complete all DAO for Pharmacist entities
 *      6. Complete all actions of Admin with CRUD
 *      7. Complete all actions of Pharmacist with CRUD
 *      8. Apply design
 *      9. Write junit tests
 *      10. Apply file generation classes
 * */
