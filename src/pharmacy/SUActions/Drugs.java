package pharmacy.SUActions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
public class Drugs extends ActionSupport implements ModelDriven<Drug> {
    private DrugsService service;
    List<Drug> list;
    private int typeid;
    private String selType;
    private List<String> drTypeNameList;
    private String errorText;
    private Drug drug = new Drug();
    private int id;
    public Drug getModel() {
        return drug;
    }

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
        drug = new Drug();
        return Action.SUCCESS;
    }
    @SkipValidation
    public String addDrug() {
        if (!myValidate()) return Action.INPUT;
        DrugTypeService tservice = new DrugTypeService();
        DrugsService service = new DrugsService();
        Drug temp = new Drug();

        typeid = tservice.getIdByName(selType);

        if (typeid == -1) {
            errorText = "Error choosing drug type! " +
                    "This must never happen, but this drug type no longer exists";
            addActionError(errorText);
            return Action.INPUT;
        }

        drug.setTypeId(typeid);
        service.insert(drug);
        return Action.SUCCESS;
    }

    @SkipValidation
    public String edit() {
        drTypeNameList = new DrugTypeService().getNames();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        DrugsService service = new DrugsService();
        DrugTypeService tservice = new DrugTypeService();

        drug = service.getById(id);

        DrugType temp = tservice.getById(drug.getTypeId());

        if (temp == null) {
            errorText = "The drug type for this drug could not be detected.";
            addActionError(errorText);
        } else {
            selType = temp.getName();
        }

        return Action.SUCCESS;
    }
    @SkipValidation
    public String update() {
        if (!myValidate()) return Action.INPUT;
        System.out.println("Here");
        DrugTypeService tservice = new DrugTypeService();
        DrugsService service = new DrugsService();

        System.out.println("seltype = "+ selType);
        typeid = tservice.getIdByName(selType);
        if (typeid == -1) {
            errorText = "Error choosing drug type! " +
                    "This must never happen, but this drug type no longer exists";
            System.out.println(errorText);
            addActionError(errorText);
            return Action.INPUT;
        }

        System.out.println("success in updating drug");
        drug.setTypeId(typeid);
        service.update(drug);
        return Action.SUCCESS;
    }

    public boolean myValidate() {
        System.out.println("Validating");
        boolean res = true;
        if (selType.equals("nll"))
        {
            addActionError("Please select a drug type!");
            res = false;
        }
        if (drug.getName().length() == 0)
        {
            addFieldError("drug.name", "This name is too long");
            res = false;
        }
        if (drug.getName().length() > 49)
        {
            addFieldError("drug.name", "This name is too long");
            res = false;
        }
        if (drug.getInstruction().length() == 0)
        {
            addFieldError("drug.instruction", "Please write the instruction");
            res = false;
        }
        drTypeNameList = new DrugTypeService().getNames();
        return res;
    }

    public List<Drug> getList() {
        return list;
    }

    public void setList(List<Drug> list) {
        this.list = list;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setDrTypeNameList(List<String> drTypeNameList) {
        this.drTypeNameList = drTypeNameList;
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
