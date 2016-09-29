package actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pharmacy.Actions.AdminReg;

import static junit.framework.Assert.assertEquals;

public class AdminRegTest {
    private AdminReg controller;

    @Before
    public void setUp() throws Exception {
        controller = new AdminReg();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void execute() throws Exception {
        controller.execute();
        if (controller.getNetwNameList().size() == 0)
            assertEquals("NOFREE", controller.execute());
    }

    @Test
    public void executeIfSuccess() throws Exception {
        controller.execute();
        if (controller.getNetwNameList().size() != 0)
            assertEquals("SUCCESS", controller.execute());
    }

}