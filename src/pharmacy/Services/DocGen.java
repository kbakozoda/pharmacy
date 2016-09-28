package pharmacy.Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

public class DocGen {
    private static DocGen ourInstance = new DocGen();

    public static DocGen getInstance() {
        return ourInstance;
    }

    private DocGen() {

    }

    public ByteArrayOutputStream printDrugsInPDF() {
        Document doc = new Document();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        try {
            pdfWriter = PdfWriter.getInstance(doc, stream);
            doc.open();
            doc.add(new Paragraph("Hello world!"));
            doc.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) doc.close();
            if (doc != null) doc.close();
        }
    return stream;
    }
}
