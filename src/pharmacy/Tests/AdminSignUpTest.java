package actions;

import com.opensymphony.xwork2.ActionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.Request;
import pharmacy.Models.User;
import pharmacy.Services.*;
import pharmacy.Actions.*;
import pharmacy.Models.Pharmacy;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class AdminSignUpTest {
    private AdminReg adminRegController;





    private AdminSignUp controller;
    private Developers developers;
    private Login login;
    private PhReg phreg;
    private PhSignUp phSignUp;
    private TryAuthorise tryAuthorise;
    private UserInfo userInfo;
    private AdminReg adminReg;

    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        adminRegController = new AdminReg();
        controller = new AdminSignUp();
        controller.setSelNetw("da");
        controller.setPassword("12345678");
        controller.setName("da");
        controller.setSurname("da");
        controller.setUsername("da");
        SURequestService suservice = new SURequestService();
        NetworkService ns = new NetworkService();
        controller.setNetwList(ns.getAll());
        developers = new Developers();
        login = new Login();
        phreg = new PhReg();
        phSignUp = new PhSignUp();
        phSignUp.setName("nanananana");
        phSignUp.setPassword("ad12345678");
        phSignUp.setPasswordconf("ad12345678");
        phSignUp.setSelPh(0);
        phSignUp.setSurname("nanananananana");
        phSignUp.setUsername("ananana");
        RequestService rservice = new RequestService();
        PharmacyService phservice = new PharmacyService();
        List<Pharmacy> plst = phservice.getAll();
        phSignUp.setPhList(plst);
        List phNmbList = new ArrayList<>();
        for (int i=0; i<plst.size(); i++) {
            if (plst.get(i).getPharmacistId() == -1) {
                int temp = plst.get(i).getNumber();
                phNmbList.add(temp);
            }
        }
        phSignUp.setPhNmbList(phNmbList);
        tryAuthorise = new TryAuthorise();
        userInfo = new UserInfo();
        userInfo.setNewPass("np");
        userInfo.setNewPassConf("np");
        userInfo.setOldPass("op");

        User user = new User();
        user.setUsername("lol");
        user.setSurname("kek");
        user.setId(0);
        user.setName("superkek");
        user.setNetworkdId(0);
        user.setPassword("1234567da");
        user.setRole(0);
        user.setPharmacyId(0);
        userInfo.setUser(user);
        adminReg = new AdminReg();
        adminReg.setNetwList(ns.getAll());
        adminReg.setPassword("12343245Fa");
        adminReg.setConfpassword("12343245Fa");
        adminReg.setName("Name");
        List<String> netwNameList = new ArrayList<String>();
        adminReg.setNetwNameList(netwNameList);
        adminReg.setSelNetw("sd");
        adminReg.setSurname("deeee");
        adminReg.setUsername("fdfsdf");

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void executeAdminReg() throws Exception {
        adminRegController.execute();
        if (adminRegController.getNetwNameList().size() == 0)
            assertEquals("NOFREE", adminRegController.execute());
    }

    @Test
    public void adminRegExecuteIfSuccess() throws Exception {
        adminRegController.execute();
        if (adminRegController.getNetwNameList().size() != 0)
            assertEquals("SUCCESS", adminRegController.execute());
    }
    @Test
    public void execute() throws Exception {
        assertEquals("SUCCESS", controller.execute());
    }
    @Test
    public void aRegExecute() throws Exception {
        assertEquals("SUCCESS", adminReg.execute());
    }


    @Test
    public void validate() throws Exception {
        controller.validate();
    }

    @Test
    public void devExecute() throws Exception {
        assertEquals("SUCCESS", developers.execute());
    }

    @Test
    public void logExecute() throws Exception {
        assertEquals("SUCCESS", login.execute());
    }

    @Test
    public void phrExecute() throws Exception {
        assertEquals("SUCCESS", phreg.execute());
    }

    @Test
    public void phsExecute() throws Exception {
        assertEquals("SUCCESS", phSignUp.execute());
    }

    @Test
    public void taExecute() throws Exception {
        assertEquals("SUCCESS", tryAuthorise.execute());
    }

    @Test
    public void logout() throws Exception {
        assertEquals("SUCCESS", login.logout());
    }

    @Test
    public void phreg() throws Exception {
        phreg.validate();
    }

    @Test
    public void phSignUp() throws Exception {
        phSignUp.validate();
    }

    @Test
    public void tryAuth() throws Exception {
        tryAuthorise.validate();
    }

}
