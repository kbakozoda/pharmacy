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


    public String sayHelloPDF() throws IOException {
        makeResponse(DocGen.getInstance().printDrugsInPDF(), "application/pdf", "hello.pdf");
        return NONE;
    }
}
