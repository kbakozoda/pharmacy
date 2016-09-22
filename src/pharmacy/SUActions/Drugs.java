package pharmacy.SUActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import pharmacy.Models.Drug;
import pharmacy.Models.DrugType;
import pharmacy.Services.DrugTypeService;
import pharmacy.Services.DrugsService;
import pharmacy.Services.PatternService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 12.09.2016.
 */
public class Drugs extends ActionSupport {
    private DrugsService service;
    List<Drug> list;
    private int id;
    private int typeid;
    private String name;
    private int agerestriction;
    private String instruction;
    private String selType;
    private List<String> drTypeNameList;
    private String errorText;
    private String newName;
    private int lastid;

    @SkipValidation
    public String execute() {
        service = new DrugsService();
        list = service.getAll();
        // TODO: if list is empty display the message that list is empty;
        return "SUCCESS";
    }
    @SkipValidation
    public String deleteDrug() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        DrugsService service = new DrugsService();
        int res = service.deleteById(id);
        if (res == 1) return "success";
        else return "error";
    }

    @SkipValidation
    public String create() {
        drTypeNameList = new DrugTypeService().getNames();
        return Action.SUCCESS;
    }

    @SkipValidation
    public String edit() {
        drTypeNameList = new DrugTypeService().getNames();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        lastid = id;
        DrugsService service = new DrugsService();
        DrugTypeService tservice = new DrugTypeService();

        name = service.getById(id).getName();
        instruction = service.getById(id).getInstruction();
        agerestriction = service.getById(id).getAgeRestrict();

        DrugType temp = tservice.getById(id);
        if (temp == null) return Action.ERROR;
        selType = temp.getName();

        return Action.SUCCESS;
    }

    public String update() {
        DrugTypeService tservice = new DrugTypeService();
        DrugsService service = new DrugsService();
        Drug temp = new Drug();
        System.out.println("seltype = "+ selType);
        typeid = tservice.getIdByName(selType);
        if (typeid == -1) {
            errorText = "Error choosing drug type! This must never happen, but..";
            return Action.ERROR;
        }
        System.out.println("last " + lastid);
        temp.setId(lastid);
        temp.setName(name);
        temp.setTypeId(typeid);
        temp.setInstruction(instruction);
        temp.setAgeRestrict(agerestriction);

        System.out.println("updating to "+ temp.getId() + " " + temp.getName() + " " + temp.getInstruction());
        service.update(temp);
        return Action.SUCCESS;
    }

    public String addDrug() {
        DrugTypeService tservice = new DrugTypeService();
        DrugsService service = new DrugsService();
        Drug temp = new Drug();
        typeid = tservice.getIdByName(selType);
        if (typeid == -1) {
            errorText = "Error choosing drug type! This must never happen, but..";
            return Action.ERROR;
            // TODO: display this text in error.jsp file.
        }

        temp.setName(name);
        temp.setTypeId(typeid);
        temp.setInstruction(instruction);
        temp.setAgeRestrict(agerestriction);

        service.insert(temp);
        return Action.SUCCESS;
    }

    public void validate() {

        if (selType.equals("nll"))
        {
            addActionError("Please select a drug type!");
        }

        if (name.length() == 0)
        {
            addFieldError("name", "This name is too long");
        }

        if (name.length() > 49)
        {
            addFieldError("name", "This name is too long");
        }

        if (instruction.length() == 0)
        {
            addFieldError("instruction", "Please write the instruction");
        }

        drTypeNameList = new DrugTypeService().getNames();
    }

    public List<Drug> getList() {
        return list;
    }

    public void setList(List<Drug> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLastid() {
        return lastid;
    }

    public void setLastid(int lastid) {
        this.lastid = lastid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgerestriction() {
        return agerestriction;
    }

    public void setAgerestriction(int agerestriction) {
        this.agerestriction = agerestriction;
    }

    public void setDrTypeNameList(List<String> drTypeNameList) {
        this.drTypeNameList = drTypeNameList;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List getDrTypeNameList() {
        return drTypeNameList;
    }

    public String getSelType() {
        return selType;
    }

    public void setSelType(String selType) {
        this.selType = selType;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
