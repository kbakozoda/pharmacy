package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.RequestToGod;
import pharmacy.Services.SURequestService;

import java.util.List;

/**
 * Created by User on 10.09.2016.
 */
public class Requests extends ActionSupport{
    private List<RequestToGod> reqList;

    public String execute() {
        SURequestService service = new SURequestService();
        reqList = service.getAll();
        return "SUCCESS";
    }

    public List<RequestToGod> getReqList() {
        return reqList;
    }
}
