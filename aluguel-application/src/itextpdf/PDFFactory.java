package itextpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFFactory {
    
    final public static String PDF_PATH = "C:\\Users\\romer\\Documents\\";
    final public static String PDF_PREFIX = "Relatorio_";
    final public static String PDF_EXTENSION = ".pdf";
    
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
            doc.close();
        }
    }
           
}
