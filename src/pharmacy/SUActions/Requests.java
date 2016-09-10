package pharmacy.SUActions;

import com.opensymphony.xwork2.ActionSupport;
import pharmacy.Models.RequestToGod;
import pharmacy.Services.ReqToGodService;

import java.util.List;

/**
 * Created by User on 10.09.2016.
 */
public class Requests extends ActionSupport{
    private List<RequestToGod> reqList;

    public String execute() {
        ReqToGodService service = new ReqToGodService();
        reqList = service.getSURequests();
        return "SUCCESS";
    }

    public List<RequestToGod> getReqList() {
        return reqList;
    }
}
