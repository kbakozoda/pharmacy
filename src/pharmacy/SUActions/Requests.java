package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import pharmacy.Models.RequestToGod;
import pharmacy.Services.SURequestService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Requests extends ActionSupport{
    private List<RequestToGod> reqList;

    public String execute() {
        SURequestService service = new SURequestService();
        reqList = service.getAll();
        return "SUCCESS";
    }

    public String approve() {
        int id;
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        SURequestService service = new SURequestService();
        service.approveById(id);
        System.out.println("SU: approving request " + id);
        return "SUCCESS";
    }

    public String decline() {
        int id;
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        id = Integer.parseInt(request.getParameter("id"));
        SURequestService service = new SURequestService();
        service.declineById(id);
        System.out.println("SU: declining request " + id);
        return "SUCCESS";
    }

    public List<RequestToGod> getReqList() {
        return reqList;
    }
}
