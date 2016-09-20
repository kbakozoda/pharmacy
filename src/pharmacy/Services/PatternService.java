package pharmacy.Services;

import java.util.regex.Pattern;

/**
 * Created by User on 20.09.2016.
 */
public class PatternService {
    private Pattern namePattern;
    private Pattern loginPattern;
    private Pattern passwordPattern;

    public PatternService() {
        namePattern = Pattern.compile("^[A-Za-z\\s]{1,60}$");
        loginPattern = Pattern.compile("^[A-Za-z0-9_-]{1,30}$");
        passwordPattern = Pattern.compile("^[A-Za-z0-9@#$%*]{8,60}$");
    }

    public Pattern getNamePattern() {
        return namePattern;
    }

    public Pattern getLoginPattern() {
        return loginPattern;
    }

    public Pattern getPasswordPattern() {
        return passwordPattern;
    }
}
