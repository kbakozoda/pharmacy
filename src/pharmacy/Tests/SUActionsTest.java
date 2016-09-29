package pharmacy.Tests;

import com.opensymphony.xwork2.ActionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pharmacy.Models.Pharmacy;
import pharmacy.Models.Request;
import pharmacy.Models.User;
import pharmacy.Models.*;
import pharmacy.Services.*;
import pharmacy.SUActions.*;
import pharmacy.Actions.*;
import pharmacy.Models.Pharmacy;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
public class SUActionsTest {
    private Drugs drugs;
    private Drug drug;
    private pharmacy.SUActions.Login login;
    private DrugType dType;
    private DrugTypes drugTypes;
    private List list;

    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        drug = new Drug();
        drug.setName("Hookah");
        drug.setAgeRestrict(18);
        drug.setId(33);
        drug.setInstruction("Smoke");
        drug.setTypeId(0);
        drugs = new Drugs();
        drugs.setDrug(drug);
        drugs.setErrorText("error");
        drugs.setTypeid(0);
        List<String> drTypeNameList = new ArrayList<String>();
        drugs.setDrTypeNameList(drTypeNameList);
        List<Drug> drugList = new ArrayList<Drug>();
        drugs.setList(drugList);
        login = new pharmacy.SUActions.Login();
        drugTypes = new DrugTypes();
        dType = new DrugType();
        dType.setName("tof");
        dType.setId(7);
        drugTypes.setDrugType(dType);
        list = new ArrayList<>();
        drugTypes.setList(list);
    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void drugsCheckTypeID() throws Exception {
        assertEquals(0, drugs.getTypeid());
    }
    @Test
    public void drugsCreate() throws Exception {
        assertNotNull(drugs.create());
    }
    @Test
    public void drugsExecute() throws Exception {
        assertEquals("SUCCESS", drugs.execute());
    }
    @Test
    public void drugsCheckDrug() throws Exception {
        assertEquals(drug, drugs.getDrug());
    }
    @Test
    public void drugCheckError() throws Exception {
        assertEquals("error", drugs.getErrorText());
    }
    @Test
    public void loginExecute() throws Exception {
        assertEquals("SUCCESS", login.execute());
    }
    @Test
    public void drugTypesExecute() throws Exception {
        assertEquals("SUCCESS", drugTypes.execute());
    }
    @Test
    public void drugTypesList() throws Exception {
        assertEquals(list, drugTypes.getList());
    }
}
