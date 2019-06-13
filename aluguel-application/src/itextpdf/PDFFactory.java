package itextpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
           
}
