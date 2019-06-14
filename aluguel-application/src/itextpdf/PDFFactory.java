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
        float[] width_cols = new float[header_cols.length];
        
        for (int i = 0; i < header_cols.length; i++) {
            width_cols[i] = (float)header_cols[i].length();
        }
        
        //criar tabela
        PdfPTable ctb = new PdfPTable(width_cols);
        ctb.setWidthPercentage(100f);

        //adicionar cabecalho da tabela
        sdf = new SimpleDateFormat("dd 'de' MMMMM");
        Font f = new Font();
        f.setColor(BaseColor.WHITE);
        PdfPCell cab1 = new PdfPCell(new Phrase("Relatório para " + sdf.format(new Date())));
        cab1.setBackgroundColor(BaseColor.BLACK);
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        
        cab1.setColspan(header_cols.length);
        ctb.addCell(cab1);
        
        for (String header_col : header_cols) {
            ctb.addCell(header_col);
        }
        ctb.setHeaderRows(1);
        
        return ctb;
    }
}
