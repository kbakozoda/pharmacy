package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.DrugType;
import pharmacy.Services.DrugTypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DrugTypes extends ActionSupport {
    List list;
    public String name;
    public int id;
    public String execute() {
        DrugTypeService service = new DrugTypeService();
        list = service.getAll();

        if (list == null){
            return "ERROR";
        }

        return "SUCCESS";
    }

    public List getList() {
        return list;
    }

    public String newDrugType() {
        return "SUCCESS";
    }

    public String drugTypeCreate(){
        DrugTypeService service = new DrugTypeService();
        DrugType temp = new DrugType();
        temp.setName(name);
        service.insert(temp);
        return "SUCCESS";
    }

    public String deleteDrugType() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        DrugTypeService service = new DrugTypeService();
        int res = service.deleteById(id);
        if (res == 1) return "SUCCESS";
        else return "ERROR";
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
}
