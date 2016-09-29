package pharmacy.Services;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import org.apache.poi.hssf.usermodel.*;
import pharmacy.Models.*;
import com.opencsv.CSVWriter;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DocGen {
    private static DocGen ourInstance = new DocGen();

    public static DocGen getInstance() {
        return ourInstance;
    }

    private List<Drug> drugs;
    private List<String> typeNames;

    private List<Network> networks;
    private List<String> adminNames;

    private List<DrugType> drugTypes;

    private List<String> drugNames;
    private List<StockElement> stock;

    private List pharmNumbs;
    private List<String> pharmacistNames;
    private List<String> pharmacistSurnames;

    private int netwid;
    private int id;

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

    public void prepareStockForPharmacy (int id) {
        StockService sts = new StockService();
        DrugsService ds = new DrugsService();
        drugNames = new ArrayList<>();
        stock = sts.getByPhId(id);
        String temp;
        for (int i=0; i<stock.size(); i++) {
            temp = ds.getById(stock.get(i).getDrugId()).getName();
            drugNames.add(temp);
        }
        this.id = id;
    }

    public void preparePharmacistsOfNetwork(int netwid) {
        PharmacyService phs = new PharmacyService();
        UserService us = new UserService();
        List<Pharmacy> pharms = phs.getAllForNetwork(netwid);
        pharmNumbs = new ArrayList<>();
        pharmacistNames = new ArrayList<>();
        pharmacistSurnames = new ArrayList<>();
        String temp;
        for (int i=0; i<pharms.size(); i++) {
            if (pharms.get(i).getPharmacistId() != -1) {
                pharmNumbs.add(pharms.get(i).getNumber());
                temp = us.getById(pharms.get(i).getPharmacistId()).getName();
                pharmacistNames.add(temp);
                temp = us.getById(pharms.get(i).getPharmacistId()).getSurname();
                pharmacistSurnames.add(temp);
            }
        }
        this.netwid = netwid;
    }

    public void prepareDrugTypes() {
        DrugTypeService dts = new DrugTypeService();
        drugTypes = dts.getAll();
    }

    public void prepareDrugs() {
        DrugsService ds = new DrugsService();
        drugs = ds.getAll();
        typeNames = new ArrayList<>();
        DrugTypeService drTypeService = new DrugTypeService();
        String temp;
        for (int i=0; i<drugs.size(); i++) {
            temp = drTypeService.getById(drugs.get(i).getTypeId()).getName();
            typeNames.add(temp);
        }
    }

    public void prepareNetworks() {
        NetworkService ns = new NetworkService();
        UserService us = new UserService();
        adminNames = new ArrayList<>();

        networks = ns.getAll();
        String temp;
        for (int i=0; i<networks.size(); i++) {
            temp = us.getById(networks.get(i).getAdminId()).getName();
            adminNames.add(temp);
        }
    }

    public ByteArrayOutputStream printDrugsInPDF() {
        Document doc = new Document();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        prepareDrugs();
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
            doc.addAuthor("Loosers inc.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) doc.close();
            if (pdfWriter != null) doc.close();
        }
    return stream;
    }

    public ByteArrayOutputStream printDrugsXLS() throws IOException{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Drugs");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Drug id"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Drug name"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Drug type"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Instructions"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Age restriction"));

        sheet.autoSizeColumn(0);
        style.setWrapText(true);
        headerCellStyle.setWrapText(true);
        int[] columnWidths = {10, 15, 15, 15, 15};
        for (int i = 0; i < columnWidths.length; i++) {
            columnWidths[i] = columnWidths[i] * 256;
        }

        prepareDrugs();

        for (int i = 0; i < drugs.size(); i++ ) {
            row = sheet.createRow(i+1);
            row.setRowStyle(style);

            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(drugs.get(i).getId());
            sheet.autoSizeColumn(0);
            sheet.setColumnWidth(0, columnWidths[0]);

            cell = row.createCell(1);
            cell.setCellStyle(style);
            HSSFRichTextString drugName = new HSSFRichTextString(drugs.get(i).getName());
            cell.setCellValue(drugName);
            sheet.autoSizeColumn(1);
            sheet.setColumnWidth(1, columnWidths[1]);

            cell = row.createCell(2);
            cell.setCellStyle(style);
            HSSFRichTextString drugType = new HSSFRichTextString(typeNames.get(i));
            cell.setCellValue(drugType);
            sheet.autoSizeColumn(2);
            sheet.setColumnWidth(2, columnWidths[2]);

            cell = row.createCell(3);
            cell.setCellStyle(style);
            HSSFRichTextString instr = new HSSFRichTextString(drugs.get(i).getInstruction());
            cell.setCellValue(instr);
            sheet.autoSizeColumn(3);
            sheet.setColumnWidth(3, columnWidths[3]);

            cell = row.createCell(4);
            cell.setCellStyle(style);
            cell.setCellValue(drugs.get(i).getAgeRestrict());
            sheet.autoSizeColumn(4);
            sheet.setColumnWidth(4, columnWidths[4]);
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return  stream;
    }

    public ByteArrayOutputStream printDrugsInCSV() throws IOException {
        prepareDrugs();
        String[] fileHeader = {"Drug id", "Drug name", "Drug Type", "Instruction", "Age restriction"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")), ',');
        writer.writeNext(fileHeader);
        for (int i = 0; i < drugs.size(); i++) {
            String[] tempArray = {String.valueOf(drugs.get(i).getId()) ,drugs.get(i).getName(), typeNames.get(i),
                    drugs.get(i).getInstruction(), String.valueOf(drugs.get(i).getAgeRestrict())};
            writer.writeNext(tempArray);
        }
        writer.close();
        return stream;
    }
}
