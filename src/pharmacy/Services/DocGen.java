package pharmacy.Services;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import pharmacy.Models.Drug;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DocGen {
    private static DocGen ourInstance = new DocGen();

    public static DocGen getInstance() {
        return ourInstance;
    }

    private DocGen() {

    }

    private static void addWaterMark(PdfWriter writer) {
        Phrase watermark = new Phrase("Loosers", FontFactory.getFont(FontFactory.HELVETICA, 40, Font.BOLD));
        Rectangle pageSize = writer.getPageSize();
        float x = (pageSize.getLeft() + pageSize.getRight()) / 2;
        float y = (pageSize.getTop() + pageSize.getBottom()) / 2;
        PdfContentByte canvas = writer.getDirectContentUnder();
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, x, y, 45);

    }

    public ByteArrayOutputStream printDrugsInPDF() {
        Document doc = new Document();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        DrugsService ds = new DrugsService();

        List<Drug> drugs = ds.getAll();
        List<String> typeNames = new ArrayList<>();
        DrugTypeService drTypeService = new DrugTypeService();
        String temp;
        for (int i=0; i<drugs.size(); i++) {
            temp = drTypeService.getById(drugs.get(i).getTypeId()).getName();
            typeNames.add(temp);
        }

        try {
            pdfWriter = PdfWriter.getInstance(doc, stream);
            doc.open();
            addWaterMark(pdfWriter);
            PdfPTable table = new PdfPTable(4);
            Paragraph title = new Paragraph();

            Font timesRomanfont = new Font(Font.FontFamily.TIMES_ROMAN,24,Font.BOLDITALIC);
            Chunk timesRomanChunk = new Chunk("List of all drugs",timesRomanfont);
            title.add(timesRomanChunk);

            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            doc.add(title);

            PdfPCell c1 = new PdfPCell(new Phrase("Drug Name"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("Drug Type"));
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c2);

            PdfPCell c3 = new PdfPCell(new Phrase("Instruction"));
            c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("Age restriction"));
            c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c4);

            for (int i=0; i<drugs.size(); i++) {
                table.addCell(drugs.get(i).getName());
                table.addCell(typeNames.get(i));
                table.addCell(drugs.get(i).getInstruction());
                table.addCell(String.valueOf(drugs.get(i).getAgeRestrict()));
            }
            doc.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) doc.close();
            if (pdfWriter != null) doc.close();
        }
    return stream;
    }
}
