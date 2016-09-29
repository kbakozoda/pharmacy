package pharmacy.Actions;

import com.opensymphony.xwork2.ActionSupport;

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
        makeResponse(DocGen.getInstance().printDrugsInPDF(), "application/pdf", "drugs.pdf");
        return NONE;
    }

    public String drugsXLS() throws IOException {
        makeResponse(DocGen.getInstance().printDrugsXLS(), "application/vnd.ms-excel", "drugs.xls");
        return NONE;
    }

    public String drugsCSV() throws IOException {
        makeResponse(DocGen.getInstance().printDrugsInCSV(), "text/csv" , "drugs.csv");
        return NONE;
    }

    public String networksPDF() throws IOException {
        makeResponse(DocGen.getInstance().printNetworksInPDF(), "application/pdf", "networks.pdf");
        return NONE;
    }

    public String networksXLS() throws IOException {
        makeResponse(DocGen.getInstance().printNetworksXLS(), "application/vnd.ms-excel", "networks.xls");
        return NONE;
    }

    public String networksCSV() throws IOException {
        makeResponse(DocGen.getInstance().printNetworksInCSV(), "text/csv" , "networks.csv");
        return NONE;
    }

    public String typesPDF() throws IOException {
        makeResponse(DocGen.getInstance().printDrTypesInPDF(), "application/pdf", "types.pdf");
        return NONE;
    }

    public String typesXLS() throws IOException {
        makeResponse(DocGen.getInstance().printDrTypesXLS(), "application/vnd.ms-excel", "types.xls");
        return NONE;
    }

    public String typesCSV() throws IOException {
        makeResponse(DocGen.getInstance().printDrTypesInCSV(), "text/csv" , "types.csv");
        return NONE;
    }

    public String stockPDF() throws IOException {
        makeResponse(DocGen.getInstance().printStockInPDF(9), "application/pdf", "types.pdf");
        return NONE;
    }

    public String stockXLS() throws IOException {
        makeResponse(DocGen.getInstance().printStockXLS(9), "application/vnd.ms-excel", "types.xls");
        return NONE;
    }

    public String stockCSV() throws IOException {
        makeResponse(DocGen.getInstance().printStockInCSV(9), "text/csv" , "types.csv");
        return NONE;
    }
}
