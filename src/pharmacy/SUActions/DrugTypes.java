package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import pharmacy.Models.DrugType;
import pharmacy.Services.DrugTypeService;
import pharmacy.Services.PatternService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrugTypes extends ActionSupport {
    List list;
    private String name;
    private int id;
    private String next;
    @SkipValidation
    public String execute() {
        DrugTypeService service = new DrugTypeService();
        list = service.getAll();

        if (list == null){
            addActionError("There are no drug types created!");
            return "ERROR";
        }

        return "SUCCESS";
    }

    public List getList() {
        return list;
    }
    @SkipValidation
    public String newDrugType() {
        next = "drugtypecreate.action";
        return "SUCCESS";
    }

    public String drugTypeCreate(){
        DrugTypeService service = new DrugTypeService();
        DrugType temp = new DrugType();
        temp.setName(name);
        service.insert(temp);
        return "SUCCESS";
    }
    @SkipValidation
    public String deleteDrugType() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        DrugTypeService service = new DrugTypeService();
        int res = service.deleteById(id);
        if (res == 1) return "SUCCESS";
        else return "ERROR";
    }
    @SkipValidation
    public String editDrugType() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        next = "editdrugtype.action?id="+id;
        DrugTypeService service = new DrugTypeService();
        name = service.getById(id).getName();
        return "SUCCESS";
    }
    @SkipValidation
    public String updateDrugType() {

        if (!editValidate()) return "INPUT";

        DrugTypeService service = new DrugTypeService();
        System.out.println("id = " + id);
        DrugType temp = new DrugType();
        temp.setId(id);
        temp.setName(name);
        service.update(temp);
        return "SUCCESS";
    }

    public void validate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Matcher m = namePattern.matcher(name);

        DrugTypeService serv = new DrugTypeService();
        if (serv.isThereByName(name))
        {
            addFieldError("name", "This name is already taken");
        }

        if (!m.matches())
        {
            addFieldError("name", "This name is invalid");
        }
    }

    public boolean editValidate() {
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Matcher m = namePattern.matcher(name);

        DrugTypeService serv = new DrugTypeService();

        if (!m.matches())
        {
            addFieldError("name", "This name is invalid");
            return false;
        }

        return true;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNext() {
        return next;
    }
}
