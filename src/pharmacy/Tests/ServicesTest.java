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
import pharmacy.Actions.*;
import pharmacy.Models.Pharmacy;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class ServicesTest {
    private DeveloperService devService;
    private DrugsService drugService;
    private Drug drug;
    private DrugTypeService drugTypeService;
    private DrugType drugType;
    private HistoryService historyService;
    private NetworkService netService;
    private Network nw;
    private PatternService patService;
    private PharmacyService pharmService;
    private Pharmacy pharmacy;
    private RequestService reqService;
    private StockService stockService;
    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        devService = new DeveloperService();
        drugService = new DrugsService();
        drug = new Drug();
        drug.setName("Hookah");
        drug.setAgeRestrict(18);
        drug.setId(33);
        drug.setInstruction("Smoke");
        drug.setTypeId(0);
        drugTypeService = new DrugTypeService();
        drugType = new DrugType();
        drugType.setName("tof");
        drugType.setId(7);
        historyService = new HistoryService();
        netService = new NetworkService();
        nw = new Network();
        nw.setId(1);
        nw.setName("lol");
        nw.setAdminId(3);
        patService = new PatternService();
        pharmService = new PharmacyService();
        pharmacy = new Pharmacy();
        pharmacy.setId(1);
        pharmacy.setAddress("Gikalo st");
        pharmacy.setNetworkId(3);
        pharmacy.setNumber(3);
        pharmacy.setPharmacistId(3);
        reqService = new RequestService();
        stockService = new StockService();

    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void devCheck() throws Exception {
        assertNotNull(devService.getDevelopers());
    }
    @Test
    public void drugDeleteCheck() throws Exception {
        assertEquals(1, drugService.deleteById(5));
    }
    @Test
    public void getAllDrugs() throws Exception {
        assertNotNull(drugService.getAll());
    }
    @Test
    public void drugGetIDCheck() throws Exception {
        assertEquals(-1, drugService.getIdByName("NotExistingDrug"));
    }
    @Test
    public void drugInsert() throws Exception {
        //assertEquals("SUCCESS", drugService.insert(drug));
        drugService.insert(drug);
    }
    @Test
    public void drugUpdate() throws Exception {
        assertEquals(0, drugService.update(drug));
    }
    @Test
    public void drugTypeDelete() throws Exception {
        assertEquals(0, drugTypeService.deleteById(1));
    }
    @Test
    public void drugTypeGetIDByNameTest() throws Exception {
        assertNotNull(drugTypeService.getIdByName("lol"));
    }
    @Test
    public void drugTypeGetTypesTest() throws Exception {
        assertNotNull(drugTypeService.getAll());
    }
    @Test
    public void drugTypeGetByIDTest() throws Exception {
        assertNull(drugTypeService.getById(1));
    }
    @Test
    public void drugTypeGetNamesTest() throws Exception {
        assertNotNull(drugTypeService.getNames());
    }
    @Test
    public void drugTypeCheckNameTest() throws Exception {
        assertEquals(true, drugTypeService.isThereByName("lol"));
    }
    @Test
    public void drugTypeUpdate() throws Exception {
        assertNotNull(drugTypeService.update(drugType));
    }
    @Test
    public void historyServiceCheckAll() throws Exception {
        assertNotNull(historyService.getAll());
    }
    @Test
    public void historyServiceDelAllByPhID() throws Exception {
        assertEquals(0, historyService.delAllByPhId(1));
    }
    @Test
    public void historyServiceGetAllByPH() throws Exception {
        assertNotNull(historyService.getAllByPh(1));
    }
    @Test
    public void netServiceGetAll() throws Exception {
        assertNotNull(netService.getAll());
    }
    @Test
    public void netServiceGetByID() throws Exception {
        assertNotNull(netService.getById(1));
    }
    @Test
    public void netServiceDeleteByID() throws Exception {
        assertEquals(1, netService.deleteById(4));
    }
    @Test
    public void netServiceGetByAdminID() throws Exception {
        assertNotNull(netService.getByAdminId(1));
    }
    @Test
    public void netServiceInsert() throws Exception {
        netService.insert(nw);
    }
    @Test
    public void netServiceUpdate() throws Exception {
        assertEquals(1, netService.update(nw));
    }
    @Test
    public void patServiceGetLogPat() throws Exception {
        assertNotNull(patService.getLoginPattern());
    }
    @Test
    public void patServiceGetPassPat() throws Exception {
        assertNotNull(patService.getPasswordPattern());
    }
    @Test
    public void patServiceGetNamePat() throws Exception {
        assertNotNull(patService.getNamePattern());
    }
    @Test
    public void pharmServiceDeleteById() throws Exception {
        assertEquals(1,pharmService.deleteById(1));
    }
    @Test
    public void pharmServiceGetAll() throws Exception {
        assertNotNull(pharmService.getAll());
    }
    @Test
    public void pharmServiceGetByID() throws Exception {
        assertNotNull(pharmService.getById(3));
    }
    @Test
    public void pharmServiceGetForNet() throws Exception {
        assertNotNull(pharmService.getAllForNetwork(3));
    }
    @Test
    public void pharmServiceGetByPhID() throws Exception {
        assertNotNull(pharmService.getByPhId(3));
    }
    @Test
    public void pharmServiceUpdate() throws Exception {
        assertEquals(0, pharmService.update(pharmacy));
    }
    @Test
    public void reqServiceGetByPhID() throws Exception {
        assertNotNull(reqService.getByPhId(1));
    }
    @Test
    public void reqServiceGetByID() throws Exception {
        assertNotNull(reqService.getById(2));
    }
    @Test
    public void reqServiceGetAll() throws Exception {
        assertNotNull(reqService.getAll());
    }
    @Test
    public void reqServiceDeleteByID() throws Exception {
        assertEquals(0, reqService.deleteById(2));
    }
    @Test
    public void reqServiceGetByNwID() throws Exception {
        assertNotNull(reqService.getByNwId(3));
    }
    @Test
    public void stockServiceGetAll() throws Exception {
        assertNotNull(stockService.getAll());
    }
    @Test
    public void stockServiceGetByID() throws Exception {
        assertNotNull(stockService.getById(2));
    }
    @Test
    public void stockServiceGetByPhID() throws Exception {
        assertNotNull(stockService.getByPhId(2));
    }
}
