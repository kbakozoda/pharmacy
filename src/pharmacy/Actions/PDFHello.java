package pharmacy.Actions;

import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import pharmacy.Services.DocGen;

/**
 * Created by User on 29.09.2016.
 */
public class PDFHello extends ActionSupport {
    private HttpServletResponse response;
    private int id;
    DocGen generator = new DocGen();

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    private void makeResponse(ByteArrayOutputStream stream, String contentType, String fileName) throws IOException {
        response = ServletActionContext.getResponse();
        response.setContentType(contentType);
        response.setHeader("Content-Disposition",
                "inline; filename=" + fileName);
        response.setContentLength(stream.size());

        OutputStream os = response.getOutputStream();
        os.write(stream.toByteArray());
        os.flush();
        os.close();
        stream.reset();
    }


    public String drugsPDF() throws IOException {
        makeResponse(generator.printDrugsInPDF(), "application/pdf", "drugs.pdf");
        return NONE;
    }

    public String drugsXLS() throws IOException {
        makeResponse(new DocGen().printDrugsXLS(), "application/vnd.ms-excel", "drugs.xls");
        return NONE;
    }

    public String drugsCSV() throws IOException {
        makeResponse(new DocGen().printDrugsInCSV(), "text/csv" , "drugs.csv");
        return NONE;
    }

    public String networksPDF() throws IOException {
        makeResponse(new DocGen().printNetworksInPDF(), "application/pdf", "networks.pdf");
        return NONE;
    }

    public String networksXLS() throws IOException {
        makeResponse(new DocGen().printNetworksXLS(), "application/vnd.ms-excel", "networks.xls");
        return NONE;
    }

    public String networksCSV() throws IOException {
        makeResponse(new DocGen().printNetworksInCSV(), "text/csv" , "networks.csv");
        return NONE;
    }

    public String typesPDF() throws IOException {
        makeResponse(new DocGen().printDrTypesInPDF(), "application/pdf", "types.pdf");
        return NONE;
    }

    public String typesXLS() throws IOException {
        makeResponse(new DocGen().printDrTypesXLS(), "application/vnd.ms-excel", "types.xls");
        return NONE;
    }

    public String typesCSV() throws IOException {
        makeResponse(new DocGen().printDrTypesInCSV(), "text/csv" , "types.csv");
        return NONE;
    }

    public String stockPDF() throws IOException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        makeResponse(new DocGen().printStockInPDF(id), "application/pdf", "stock.pdf");
        return NONE;
    }

    public String stockXLS() throws IOException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        makeResponse(new DocGen().printStockXLS(id), "application/vnd.ms-excel", "stock.xls");
        return NONE;
    }

    public String stockCSV() throws IOException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        makeResponse(new DocGen().printStockInCSV(id), "text/csv" , "stock.csv");
        return NONE;
    }

    public String phstPDF() throws IOException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        makeResponse(new DocGen().printPhInPDF(id), "application/pdf", "pharmacists.pdf");
        return NONE;
    }

    public String phstXLS() throws IOException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        makeResponse(new DocGen().printPhXLS(id), "application/vnd.ms-excel", "pharmacists.xls");
        return NONE;
    }

    public String phstCSV() throws IOException {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        makeResponse(new DocGen().printPhInCSV(id), "text/csv" , "pharmacists.csv");
        return NONE;
    }
}
