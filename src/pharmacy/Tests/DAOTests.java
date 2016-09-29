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
import pharmacy.DAO.*;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
public class DAOTests {
    private DrugsDAO drugs;
    private Drug drug;
    private DrugTypesDAO drugTypes;
    private DrugType dType;
    private HistoryDAO historyDAO;
    private NetworkDAO networkDAO;
    private PharmacyDAO pharmacyDAO;
    private Pharmacy pharmacy;
    private RequestDAO requestDAO;
    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        drugs = new DrugsDAO();
        drug = new Drug();
        drug.setName("Hookah");
        drug.setAgeRestrict(18);
        drug.setId(33);
        drug.setInstruction("Smoke");
        drug.setTypeId(0);
        drugTypes = new DrugTypesDAO();
        dType = new DrugType();
        dType.setName("tof");
        dType.setId(7);
        historyDAO = new HistoryDAO();
        networkDAO = new NetworkDAO();
        pharmacyDAO = new PharmacyDAO();
        pharmacy = new Pharmacy();
        pharmacy.setId(1);
        pharmacy.setAddress("Gikalo st");
        pharmacy.setNetworkId(3);
        pharmacy.setNumber(3);
        pharmacy.setPharmacistId(3);
        requestDAO = new RequestDAO();

    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void drugsCheckTypeID() throws Exception {
        assertEquals(1, drugs.deleteById(-1));
    }
    @Test
    public void drugsGetAllCheck() throws Exception {
        assertNotNull(drugs.getAll());
    }
    @Test
    public void drugsCheckDrugsByName() throws Exception {
        assertEquals(-1, drugs.getIdByName("NotRealName"));
    }
    @Test
    public void drugsGetByID() throws Exception {
        assertNull(drugs.getById(-11));
    }
    @Test
    public void drugsUpdateDrug() throws Exception {
        assertEquals(0, drugs.update(drug));
    }
    @Test
    public void drugTypesGetAll() throws Exception {
        assertNotNull(drugTypes.getAll());
    }
    @Test
    public void drugTypesGetByID() throws Exception {
        assertNull(drugTypes.getById(1));
    }
    @Test
    public void drugTypesGetNames() throws Exception {
        assertNotNull(drugTypes.getAllNames());
    }
    @Test
    public void drugTypesGetByName() throws Exception {
        assertNotNull(drugTypes.getIdByName("alcohol"));
    }
    @Test
    public void drugTypesDeleteByID() throws Exception {
        assertEquals(1, drugTypes.deleteById(1));
    }
    @Test
    public void drugTypesCheckName() throws Exception {
        assertEquals(false, drugTypes.isNameTaken("randomname"));
    }
    @Test
    public void drugTypesUpdate() throws Exception {
        assertEquals(0, drugTypes.update(dType));
    }
    @Test
    public void historyDAOGetAll() throws Exception {
        assertNotNull(historyDAO.getAll());
    }
    @Test
    public void historyDAOGetAllForId() throws Exception {
        assertNotNull(historyDAO.getAllFor(1));
    }
    @Test
    public void historyDAODelete() throws Exception {
        assertEquals(1, historyDAO.deleteById(1));
    }
    @Test
    public void historyDAODeleteAll() throws Exception {
        assertEquals(1, historyDAO.delAllByPhId(1));
    }
    @Test
    public void networkDAOGetAll() throws Exception {
        assertNotNull(networkDAO.getAll());
    }
    @Test
    public void networkDAOGetAllForId() throws Exception {
        assertNotNull(networkDAO.getById(3));
    }
    @Test
    public void networkDAODeleteId() throws Exception {
        assertEquals(1, networkDAO.deleteById(1));
    }
    @Test
    public void networkDAOGetAllForAdmin() throws Exception {
        assertNull(networkDAO.getByAdminId(1));
    }
    @Test
    public void pharmacyDAOGetAll() throws Exception {
        assertNotNull(pharmacyDAO.getAll());
    }
    @Test
    public void pharmacyDAODelete() throws Exception {
        assertEquals(1, pharmacyDAO.deleteById(1));
    }
    @Test
    public void pharmacyDAOGetByID() throws Exception {
        assertNull(pharmacyDAO.getById(-1));
    }
    @Test
    public void pharmacyDAOGetAllForNetwork() throws Exception {
        assertNotNull(pharmacyDAO.getAllForNetwork(1));
    }
    @Test
    public void pharmacyDAOGetByPhID() throws Exception {
        assertNull(pharmacyDAO.getByPhId(-1));
    }
    @Test
    public void pharmacyDAOInsert() throws Exception {
        pharmacyDAO.insert(pharmacy);
    }

    @Test
    public void pharmacyDAOUpdate() throws Exception {
        assertEquals(0, pharmacyDAO.update(pharmacy));
    }
    @Test
    public void requestDAOGetAll() throws Exception {
        assertNotNull(requestDAO.getAll());
    }
    @Test
    public void requestDAOGetByPhID() throws Exception {
        assertNotNull(requestDAO.getByPhId(2));
    }
    @Test
    public void requestDAOByID() throws Exception {
        assertNull(requestDAO.getById(2));
    }
    @Test
    public void requestDAOByNWID() throws Exception {
        assertNotNull(requestDAO.getByNwId(3));
    }
}
