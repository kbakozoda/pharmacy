package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import pharmacy.Models.DrugType;
import pharmacy.Services.DrugTypeService;
import pharmacy.Services.PatternService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrugTypes extends ActionSupport implements ModelDriven<DrugType> {
    List list;
    private DrugType drugType;
    private DrugTypeService service = new DrugTypeService();

    public DrugType getModel() {
        return drugType;
    }
    @SkipValidation
    public String execute() {
        System.out.println("Execute drugtypes");
        drugType = new DrugType();
        list = service.getAll();

        if (list == null){
            addActionError("There are no drug types created!");
            return "ERROR";
        }

        return "SUCCESS";
    }

    @SkipValidation
    public String newDrugType() {
        drugType = new DrugType();
        return "SUCCESS";
    }

    public String drugTypeCreate(){
        service.insert(drugType);
        return "SUCCESS";
    }
    @SkipValidation
    public String deleteDrugType() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int res = service.deleteById(Integer.parseInt(request.getParameter("id")));
        if (res == 1) return "SUCCESS";
        else return "ERROR";
    }
    @SkipValidation
    public String editDrugType() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        drugType = service.getById(Integer.parseInt(request.getParameter("id")));
        System.out.println("Chosen drugType: "+ drugType.getName() + " " + drugType.getId());
        return "SUCCESS";
    }

    public String updateDrugType() {
        service.update(drugType);
        return "SUCCESS";
    }

    public void validate() {
        System.out.println("Validating " + drugType.getName() + " " + drugType.getId());
        PatternService ps = new PatternService();
        Pattern namePattern = ps.getNamePattern();
        Matcher m = namePattern.matcher(drugType.getName());

        List<DrugType> list = service.getAll();
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getName().equals(drugType.getName()) && list.get(i).getId() != drugType.getId()) {
                addActionError("This name is already taken");
            }
        }

        if (!m.matches())
        {
            System.out.println("name invalid");
            addActionError("This name is invalid");
        }
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }
}
