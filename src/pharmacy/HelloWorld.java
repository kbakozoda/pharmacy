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
