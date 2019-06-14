package itextpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PDFFactory {
    
    final private static String PDF_PATH = "C:\\Users\\romer\\Documents\\";
    final private static String PDF_PREFIX = "Relatorio_";
    final private static String PDF_EXTENSION = ".pdf";
    final private static String PDF_CREATOR = "Aluguel de Consoles Team";
    
    public static Document getDocument(String nome) throws DocumentException {
        
        Document doc = new Document();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String data = sdf.format(new Date());
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(PDF_PATH + PDF_PREFIX + nome + data + PDF_EXTENSION));
            
            doc.open();
            
            return doc;
        } catch (DocumentException | IOException de) {
            System.out.println(de.getMessage());
        }

        return null;
    }
    
    public static void closeDocument(Document doc) {
        if (doc != null) {
                        
            doc.setMargins(3, 3, 2, 2);
            doc.addAuthor(PDF_CREATOR);
            doc.addCreationDate();
            doc.addCreator(PDF_CREATOR);
            doc.addKeywords("Relatório, Cadastro");
            
            doc.close();
        }
    }
           
    
    public static PdfPTable getTable(String[] header_cols) {
        SimpleDateFormat sdf;
        
        //criar tabela
        PdfPTable ctb = new PdfPTable(header_cols.length);
        ctb.setWidthPercentage(100f);
        ctb.getDefaultCell().setUseAscender(true);
        ctb.getDefaultCell().setUseDescender(true);

        //adicionar cabecalho da tabela
        sdf = new SimpleDateFormat("EEEEE, dd 'de' MMMMM 'de' yyyy");
        Font f = new Font();
        f.setColor(BaseColor.WHITE);
        PdfPCell cab1 = new PdfPCell(new Phrase("Relatório para " + sdf.format(new Date()), f));
        cab1.setBackgroundColor(BaseColor.BLACK);
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        
        cab1.setColspan(header_cols.length);
        ctb.addCell(cab1);
        ctb.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        for (String header_col : header_cols) {
            ctb.addCell(header_col);
        }
        ctb.getDefaultCell().setBackgroundColor(null);
        ctb.setHeaderRows(2);
        
        return ctb;
    }
}
