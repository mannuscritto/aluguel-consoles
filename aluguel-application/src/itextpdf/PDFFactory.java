package itextpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFFactory {
    
    public static Document getDocument(String nome) throws DocumentException {
        
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\romer\\Documents" + nome));
            
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
